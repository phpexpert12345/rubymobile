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
 * Use the {@link UsePointsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UsePointsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private UsePointsAdapter receivePointsAdapter;

    @BindView(R.id.rvUsePoints)
    RecyclerView rvUsePoints;

    public UsePointsFragment() {
        // Required empty public constructor
    }


    public static UsePointsFragment newInstance(String param1, String param2) {
        UsePointsFragment fragment = new UsePointsFragment();
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
        View view= inflater.inflate(R.layout.fragment_use_points, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        receivePointsAdapter = new UsePointsAdapter(getContext(), UsePointsFragment.this);
        rvUsePoints.setLayoutManager(new GridLayoutManager(getContext(), 1));
        rvUsePoints.setAdapter(receivePointsAdapter);
    }
}