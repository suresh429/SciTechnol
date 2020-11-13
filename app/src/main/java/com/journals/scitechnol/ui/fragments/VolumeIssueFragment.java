package com.journals.scitechnol.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;
import com.journals.scitechnol.databinding.FragmentInPressBinding;
import com.journals.scitechnol.databinding.FragmentVolumeIssueBinding;
import com.journals.scitechnol.helper.utils;
import com.journals.scitechnol.model.VolumeIssueResponse;
import com.journals.scitechnol.ui.adapter.VolumeIssueAdapter;
import com.journals.scitechnol.ui.viewmodel.VolumeIssueViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VolumeIssueFragment#} factory method to
 * create an instance of this fragment.
 */
public class VolumeIssueFragment extends Fragment {


    FragmentVolumeIssueBinding fragmentVolumeIssueBinding;

    private static final String TAG = "VolumeIssueFragment";
    public static final int MobileData = 2;
    ArrayList<VolumeIssueResponse.VolIssueDetailsBean> volIssueDetailsBeanArrayList = new ArrayList<>();
    VolumeIssueViewModel volumeIssueViewModel;

    VolumeIssueAdapter volumeIssueAdapter;


    String journalcode, year, month, ActionBarTitle;

    public VolumeIssueFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentVolumeIssueBinding = FragmentVolumeIssueBinding.inflate(getLayoutInflater(), container, false);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            journalcode = getArguments().getString("journal");
            month = getArguments().getString("month");
            year = getArguments().getString("year");
            ActionBarTitle = getArguments().getString("ActionBarTitle");
        }
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle(ActionBarTitle);

        volumeIssueViewModel = new ViewModelProvider(this).get(VolumeIssueViewModel.class);
        volumeIssueViewModel.init(journalcode,month, year, requireActivity());

        // progress bar
        volumeIssueViewModel.getProgressbarObservable().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                fragmentVolumeIssueBinding.progressBar.setVisibility(View.VISIBLE);

            } else {
                fragmentVolumeIssueBinding.progressBar.setVisibility(View.GONE);
            }
        });

        // Alert toast msg
        volumeIssueViewModel.getToastObserver().observe(getViewLifecycleOwner(), message -> {
            Snackbar snackbar = Snackbar.make(fragmentVolumeIssueBinding.getRoot().getRootView(), message, Snackbar.LENGTH_LONG);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.BLACK);
            snackbar.show();

            utils.noNetworkAlert(getActivity(), message);
        });

        // get home data
        volumeIssueViewModel.getVolumeIssueRepository().observe(getViewLifecycleOwner(), homeResponse -> {


            if (homeResponse.isStatus()) {
                List<VolumeIssueResponse.VolIssueDetailsBean> volIssueDetailsBeanList = homeResponse.getVolIssueDetails();

                volIssueDetailsBeanArrayList.addAll(volIssueDetailsBeanList);

                volumeIssueAdapter = new VolumeIssueAdapter(volIssueDetailsBeanList, requireActivity());
                fragmentVolumeIssueBinding.recyclerVolumeIssueList.setAdapter(volumeIssueAdapter);

                volumeIssueAdapter.notifyDataSetChanged();

                fragmentVolumeIssueBinding.progressBar.setVisibility(View.GONE);
                fragmentVolumeIssueBinding.txtEmptyView.setVisibility(View.GONE);
                Log.d(TAG, "onCreateView: " + " data found");
            } else {
                Log.d(TAG, "onCreateView: " + "NO data");
                fragmentVolumeIssueBinding.recyclerVolumeIssueList.setVisibility(View.GONE);
                fragmentVolumeIssueBinding.txtEmptyView.setVisibility(View.VISIBLE);
            }
        });


        return fragmentVolumeIssueBinding.getRoot();
    }


}