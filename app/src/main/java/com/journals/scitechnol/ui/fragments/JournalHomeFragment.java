package com.journals.scitechnol.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;
import com.journals.scitechnol.databinding.FragmentCategoryBinding;
import com.journals.scitechnol.databinding.FragmentJournalHomeBinding;
import com.journals.scitechnol.helper.utils;
import com.journals.scitechnol.ui.viewmodel.JournalHomeViewModel;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JournalHomeFragment#} factory method to
 * create an instance of this fragment.
 */
public class JournalHomeFragment extends Fragment {
    JournalHomeViewModel journalHomeViewModel;

    FragmentJournalHomeBinding fragmentJournalHomeBinding;
    String ActionBarTitle, journal;

    public JournalHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentJournalHomeBinding = FragmentJournalHomeBinding.inflate(getLayoutInflater(),container,false);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            ActionBarTitle = getArguments().getString("ActionBarTitle");
            journal = getArguments().getString("journal");

        }
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle(ActionBarTitle);



        journalHomeViewModel = new ViewModelProvider(this).get(JournalHomeViewModel.class);
        journalHomeViewModel.init(journal,requireActivity());

        // progress bar
        journalHomeViewModel.getProgressbarObservable().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean){
                fragmentJournalHomeBinding.progressBar.setVisibility(View.VISIBLE);

            }else {
                fragmentJournalHomeBinding.progressBar.setVisibility(View.GONE);
            }
        });

        // Alert toast msg
        journalHomeViewModel.getToastObserver().observe(getViewLifecycleOwner(), message -> {
            Snackbar snackbar = Snackbar.make(fragmentJournalHomeBinding.getRoot().getRootView(), message, Snackbar.LENGTH_LONG);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.BLACK);
            snackbar.show();

            utils.noNetworkAlert(getActivity(),message);
        });

        // get home data
        journalHomeViewModel.getJournalHomeRepository().observe(getViewLifecycleOwner(), homeResponse -> {
           // List<JournalHomeResponse> catDetailsBeanList = homeResponse.getAbt_journal_details();

            if (homeResponse.isStatus()){
                fragmentJournalHomeBinding.txtJournalHome.setText(Html.fromHtml(homeResponse.getAbtJournalDetails()));
                fragmentJournalHomeBinding.txtJournalHome.setMovementMethod(LinkMovementMethod.getInstance());
                fragmentJournalHomeBinding.txtEmptyView.setVisibility(View.GONE);

            }else {
                fragmentJournalHomeBinding.txtEmptyView.setVisibility(View.VISIBLE);
                fragmentJournalHomeBinding.txtJournalHome.setVisibility(View.GONE);
            }


        });




        return fragmentJournalHomeBinding.getRoot();
    }


}