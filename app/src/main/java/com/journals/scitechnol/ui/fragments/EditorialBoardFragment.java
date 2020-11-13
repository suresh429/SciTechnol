package com.journals.scitechnol.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;
import com.journals.scitechnol.databinding.FragmentEditorialBoardBinding;
import com.journals.scitechnol.helper.utils;
import com.journals.scitechnol.model.EditorialBoardResponse;
import com.journals.scitechnol.ui.adapter.EditorialBoardAdapter;
import com.journals.scitechnol.ui.viewmodel.EditorialViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EditorialBoardFragment extends Fragment {


    ArrayList<EditorialBoardResponse.EditorialboardarrBean> editorialboardarrBeanArrayList = new ArrayList<>();
    EditorialViewModel editorialViewModel;
    FragmentEditorialBoardBinding fragmentEditorialBoardBinding;
    EditorialBoardAdapter editorialBoardAdapter;
    String journal, ActionBarTitle;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fragmentEditorialBoardBinding = FragmentEditorialBoardBinding.inflate(getLayoutInflater(), container, false);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            journal = getArguments().getString("journal");
            ActionBarTitle = getArguments().getString("ActionBarTitle");
        }
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle(ActionBarTitle);

        editorialViewModel = new ViewModelProvider(this).get(EditorialViewModel.class);
        editorialViewModel.init(journal, requireActivity());

        // Alert toast msg
        editorialViewModel.getToastObserver().observe(getViewLifecycleOwner(), message -> {
            // Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            Snackbar snackbar = Snackbar.make(fragmentEditorialBoardBinding.getRoot().getRootView(), message, Snackbar.LENGTH_LONG);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.BLACK);
            snackbar.show();

            utils.noNetworkAlert(getActivity(), message);


        });


        // progress bar
        editorialViewModel.getProgressbarObservable().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                fragmentEditorialBoardBinding.progressBar.setVisibility(View.VISIBLE);

            } else {
                fragmentEditorialBoardBinding.progressBar.setVisibility(View.GONE);

            }
        });


        // get home data
        editorialViewModel.getEditorialBoardResponseLiveData().observe(getViewLifecycleOwner(), homeResponse -> {
            List<EditorialBoardResponse.EditorialboardarrBean> catDetailsBeanList = homeResponse.getEditorialboardarr();

            editorialboardarrBeanArrayList.addAll(catDetailsBeanList);

            editorialBoardAdapter = new EditorialBoardAdapter(catDetailsBeanList, getActivity());
            fragmentEditorialBoardBinding.recyclerScientificJournals.setAdapter(editorialBoardAdapter);


            fragmentEditorialBoardBinding.progressBar.setVisibility(View.GONE);

            editorialBoardAdapter.notifyDataSetChanged();
        });


        return fragmentEditorialBoardBinding.getRoot();
    }


}