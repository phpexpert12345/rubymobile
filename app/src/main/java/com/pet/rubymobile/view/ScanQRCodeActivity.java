package com.pet.rubymobile.view;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.PermissionRequest;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.android.gms.vision.text.Line;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.single.PermissionListener;
import com.pet.rubymobile.BuildConfig;
import com.pet.rubymobile.R;
import com.pet.rubymobile.adapter.ContactAdapter;
import com.pet.rubymobile.adapter.RecentContactAdapter;
import com.pet.rubymobile.util.FilePath;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScanQRCodeActivity extends AppCompatActivity {

    @BindView(R.id.surfaceView)
    SurfaceView surfaceView;
    @BindView(R.id.txtBarcodeValue)
    TextView txtBarcodeValue;
    @BindView(R.id.rvRecentContact)
    RecyclerView rvRecentContact;
    @BindView(R.id.rvType)
    RecyclerView rvType;
    @BindView(R.id.rvContact)
    RecyclerView rvContact;
    @BindView(R.id.ivClose)
    LinearLayout ivClose;
    @BindView(R.id.ivFlash)
    LinearLayout ivFlash;
    @BindView(R.id.ivGallery)
    LinearLayout ivGallery;
    @BindView(R.id.ivScan)
    LinearLayout ivScan;
    private BarcodeDetector barcodeDetector;
    private CameraSource cameraSource;
    private static final int REQUEST_CAMERA_PERMISSION = 201;
    String intentData = "";
    boolean isEmail = false;

    @BindView(R.id.bottom_sheet)
    LinearLayout layoutBottomSheet;
    @BindView(R.id.bar)
    View bar;
    @BindView(R.id.etNumber)
    AppCompatEditText etNumber;

    private Context mContext;
    private BottomSheetBehavior sheetBehavior;
    private static final int CAMERA_REQUEST = 123;
    boolean hasCameraFlash = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr);
        ButterKnife.bind(this);
        mContext = ScanQRCodeActivity.this;

        setRecentAdapter();
        setContactAdapter();

        final Animation animation = AnimationUtils.loadAnimation(ScanQRCodeActivity.this, R.anim.anim);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
//                bar.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        bar.startAnimation(animation);

        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
//                        btnBottomSheet.setText("Close Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
//                        btnBottomSheet.setText("Expand Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        etNumber.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                return false;
            }
        });
    }

    private void setContactAdapter() {
        rvContact.setLayoutManager(new LinearLayoutManager(mContext));
        ContactAdapter contactAdapter = new ContactAdapter(mContext);
        rvContact.setAdapter(contactAdapter);
    }

    private void setRecentAdapter() {
        rvRecentContact.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));
        RecentContactAdapter recentContactAdapter = new RecentContactAdapter(mContext);
        rvRecentContact.setAdapter(recentContactAdapter);
    }

    @OnClick(R.id.bottom_sheet)
    public void toggleBottomSheet() {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//            btnBottomSheet.setText("Close sheet");
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//            btnBottomSheet.setText("Expand sheet");
        }
    }

    private void initialiseDetectorsAndSources() {

        Toast.makeText(getApplicationContext(), "Barcode scanner started", Toast.LENGTH_SHORT).show();
        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS)
                .build();

        cameraSource = new CameraSource.Builder(this, barcodeDetector)
                .setRequestedPreviewSize(1920, 1080)
                .setAutoFocusEnabled(true) //you should add this feature
                .build();

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    if (ActivityCompat.checkSelfPermission(ScanQRCodeActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                        cameraSource.start(surfaceView.getHolder());
                    } else {
                        ActivityCompat.requestPermissions(ScanQRCodeActivity.this, new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST);

                        hasCameraFlash = mContext.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
                Toast.makeText(getApplicationContext(), "To prevent memory leaks barcode scanner has been stopped", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();
                if (barcodes.size() != 0) {
                    openDialog(barcodes);
                }
            }
        });
    }

    private void openDialog(SparseArray<Barcode> barcodes) {
        final Dialog dialog = new Dialog(ScanQRCodeActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_qr_text);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.CENTER;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_BLUR_BEHIND;
        window.setAttributes(wlp);
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setCancelable(true);
        AppCompatTextView tvText = dialog.findViewById(R.id.tvText);
        tvText.post(new Runnable() {
            @Override
            public void run() {
                if (barcodes.valueAt(0).email != null) {
                    txtBarcodeValue.removeCallbacks(null);
                    intentData = barcodes.valueAt(0).email.address;
                    txtBarcodeValue.setText(intentData);
                    isEmail = true;
                } else {
                    isEmail = false;
                    intentData = barcodes.valueAt(0).displayValue;
                    txtBarcodeValue.setText(intentData);
                }
            }
        });
        dialog.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            cameraSource.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(ScanQRCodeActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            initialiseDetectorsAndSources();
        } else {
            ActivityCompat.requestPermissions(ScanQRCodeActivity.this, new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST);
        }
    }

    boolean flash = false;

    @OnClick({R.id.ivClose, R.id.ivFlash, R.id.ivGallery, R.id.ivScan})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivClose:
                finish();
                break;
            case R.id.ivFlash:
                if (hasCameraFlash) {
                    if (flash)
                        flashLightOff();
                    else
                        flashLightOn();
                } else {
                    Toast.makeText(ScanQRCodeActivity.this, "No flash available on your device", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ivGallery:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select File"), PICK_FROM_FILE_MANAGER);
                break;
            case R.id.ivScan:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            Uri photoURI = null;
            switch (requestCode) {
                case PICK_FROM_FILE_MANAGER:
                    if (resultCode == RESULT_OK && data != null) {
                        try {
                            File p = null;
                            String pathHolder = null;

                            photoURI = data.getData();
                            if (photoURI != null) {
                                p = new File(String.valueOf(photoURI));
                            }

                            try {
                                pathHolder = FilePath.getPath(mContext, photoURI);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            if (pathHolder != null && p != null) {
                                File newFile = new File(pathHolder);

                                Toast.makeText(mContext, "File Selected", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
        }
    }

    public final int PICK_FROM_FILE_MANAGER = 101;

    private void openSettings() {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", BuildConfig.APPLICATION_ID, null);
        intent.setData(uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void flashLightOn() {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
            flash = true;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void flashLightOff() {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
            flash = false;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CAMERA_REQUEST:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    buttonEnable.setEnabled(false);
//                    buttonEnable.setText("Camera Enabled");
//                    imageFlashlight.setEnabled(true);
                    initialiseDetectorsAndSources();
                } else {
                    Toast.makeText(ScanQRCodeActivity.this, "Permission Denied for the Camera", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}