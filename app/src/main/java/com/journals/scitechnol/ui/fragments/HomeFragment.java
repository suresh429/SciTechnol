package com.journals.scitechnol.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.google.android.material.snackbar.Snackbar;
import com.journals.scitechnol.helper.utils;
import com.journals.scitechnol.ui.adapter.RecentPublicationsAdapter;
import com.journals.scitechnol.ui.adapter.ScientificJournalsAdapter;
import com.journals.scitechnol.databinding.FragmentHomeBinding;
import com.journals.scitechnol.model.HomeResponse;
import com.journals.scitechnol.ui.viewmodel.HomeViewModel;


import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment  {

   /* public static final int MobileData = 2;
    public static final int WifiData = 1;

    private LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);*/

    ArrayList<HomeResponse.CatDetailsBean> scientificJournalsList = new ArrayList<>();
    ArrayList<HomeResponse.RecentPublicationsBean> currentIssuesList = new ArrayList<>();
    HomeViewModel homeViewModel;
    FragmentHomeBinding fragmentHomeBinding;
    ScientificJournalsAdapter scientificJournalsAdapter;
    RecentPublicationsAdapter recentPublicationsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fragmentHomeBinding = FragmentHomeBinding.inflate(getLayoutInflater(), container, false);

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.init("1",requireActivity());

        // Alert toast msg
        homeViewModel.getToastObserver().observe(getViewLifecycleOwner(), message -> {
           // Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            Snackbar snackbar = Snackbar.make(fragmentHomeBinding.getRoot().getRootView(), message, Snackbar.LENGTH_LONG);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.BLACK);
            snackbar.show();

            utils.noNetworkAlert(getActivity(),message);


        });


        // progress bar
        homeViewModel.getProgressbarObservable().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean){
                fragmentHomeBinding.progressBar.setVisibility(View.VISIBLE);
                fragmentHomeBinding.txtJournalName.setVisibility(View.GONE);
                fragmentHomeBinding.txtCurrentIssueName.setVisibility(View.GONE);
            }else {
                fragmentHomeBinding.progressBar.setVisibility(View.GONE);
                fragmentHomeBinding.txtJournalName.setVisibility(View.VISIBLE);
                fragmentHomeBinding.txtCurrentIssueName.setVisibility(View.VISIBLE);
            }
        });


        // get home data
        homeViewModel.getHomeRepository().observe(getViewLifecycleOwner(), homeResponse -> {
            List<HomeResponse.CatDetailsBean> catDetailsBeanList = homeResponse.getCatDetails();
            List<HomeResponse.RecentPublicationsBean> currissueHighlightsBeanList = homeResponse.getRecentPublications();

            scientificJournalsList.addAll(catDetailsBeanList);
            currentIssuesList.addAll(currissueHighlightsBeanList);

            scientificJournalsAdapter = new ScientificJournalsAdapter(catDetailsBeanList,getActivity());
            fragmentHomeBinding.recyclerScientificJournals.setAdapter(scientificJournalsAdapter);

            recentPublicationsAdapter = new RecentPublicationsAdapter(currissueHighlightsBeanList,requireActivity());
            fragmentHomeBinding.recyclerHomeCurrentIssue.setAdapter(recentPublicationsAdapter);

            fragmentHomeBinding.progressBar.setVisibility(View.GONE);

            scientificJournalsAdapter.notifyDataSetChanged();
            recentPublicationsAdapter.notifyDataSetChanged();
        });



        return fragmentHomeBinding.getRoot();
    }

}