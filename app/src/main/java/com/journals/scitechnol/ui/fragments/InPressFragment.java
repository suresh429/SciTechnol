package com.journals.scitechnol.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;
import com.journals.scitechnol.databinding.FragmentInPressBinding;
import com.journals.scitechnol.helper.utils;
import com.journals.scitechnol.model.InPressResponse;
import com.journals.scitechnol.ui.adapter.InPressAdapter;
import com.journals.scitechnol.ui.viewmodel.InPressViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InPressFragment#} factory method to
 * create an instance of this fragment.
 */
public class InPressFragment extends Fragment {

   
    FragmentInPressBinding fragmentInPressBinding;

    private static final String TAG = "CategoryFragment";
    ArrayList<InPressResponse.InpressDetailsBean> inpressDetailsBeanArrayList = new ArrayList<>();
    InPressViewModel inPressViewModel;

    InPressAdapter inPressAdapter;

    String journalcode,ActionBarTitle;
    public InPressFragment() {
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
        fragmentInPressBinding=FragmentInPressBinding.inflate(getLayoutInflater(),container,false);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            journalcode = getArguments().getString("journal");
            ActionBarTitle = getArguments().getString("ActionBarTitle");
        }
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle(ActionBarTitle);

        inPressViewModel = new ViewModelProvider(this).get(InPressViewModel.class);
        inPressViewModel.init(journalcode,requireActivity());

        // progress bar
        inPressViewModel.getProgressbarObservable().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean){
                fragmentInPressBinding.progressBar.setVisibility(View.VISIBLE);

            }else {
                fragmentInPressBinding.progressBar.setVisibility(View.GONE);
            }
        });

        // Alert toast msg
        inPressViewModel.getToastObserver().observe(getViewLifecycleOwner(), message -> {
            Snackbar snackbar = Snackbar.make(fragmentInPressBinding.getRoot().getRootView(), message, Snackbar.LENGTH_LONG);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.BLACK);
            snackbar.show();

            utils.noNetworkAlert(getActivity(),message);
        });

        // get home data
        inPressViewModel.getInPressRepository().observe(getViewLifecycleOwner(), homeResponse -> {


            if (homeResponse.isStatus()) {
                List<InPressResponse.InpressDetailsBean> inpressDetailsBeanList = homeResponse.getInpressDetails();

                inpressDetailsBeanArrayList.addAll(inpressDetailsBeanList);

                inPressAdapter = new InPressAdapter(inpressDetailsBeanList,requireActivity());
                fragmentInPressBinding.recyclerInPressList.setAdapter(inPressAdapter);
                inPressAdapter.notifyDataSetChanged();
                fragmentInPressBinding.progressBar.setVisibility(View.GONE);
                fragmentInPressBinding.txtEmptyView.setVisibility(View.GONE);
                Log.d(TAG, "onCreateView: "+" data found");
            }else {
                Log.d(TAG, "onCreateView: "+"NO data");
                fragmentInPressBinding.recyclerInPressList.setVisibility(View.GONE);
                fragmentInPressBinding.txtEmptyView.setVisibility(View.VISIBLE);
            }
        });



        return fragmentInPressBinding.getRoot();
    }


}