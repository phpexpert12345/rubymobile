package com.pet.rubymobile.insentive.pointHistory;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReceivePointsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReceivePointsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    @BindView(R.id.rvRPoints)
    RecyclerView rvRPoints;

    private ReceivePointsAdapter receivePointsAdapter;

    public ReceivePointsFragment() {

    }


    public static ReceivePointsFragment newInstance(String param1, String param2) {
        ReceivePointsFragment fragment = new ReceivePointsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_receive_points, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        receivePointsAdapter = new ReceivePointsAdapter(getContext(), ReceivePointsFragment.this);
        rvRPoints.setLayoutManager(new GridLayoutManager(getContext(), 1));
        rvRPoints.setAdapter(receivePointsAdapter);
    }
}