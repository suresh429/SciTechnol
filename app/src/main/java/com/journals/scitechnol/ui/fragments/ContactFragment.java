package com.journals.scitechnol.ui.fragments;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;
import com.journals.scitechnol.R;
import com.journals.scitechnol.databinding.FragmentContactBinding;
import com.journals.scitechnol.model.ContactResponse;
import com.journals.scitechnol.model.JournalsListResponse;
import com.journals.scitechnol.ui.viewmodel.JournalListViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.content.ContentValues.TAG;

public class ContactFragment extends Fragment implements View.OnClickListener {


    ArrayList<JournalsListResponse.JournalDetailsBean> journalDetailsBeanArrayList = new ArrayList<>();
    ArrayList<JournalsListResponse.CountryDetailsBean> countryDetailsBeanArrayList = new ArrayList<>();
    List<String> journalNameList;
    List<String> journalCodeList;
    List<String> countryList;

    String journalcode, fname, lname, email,ucat,dept, phone,country, message;
    JournalListViewModel journalListViewModel;
    FragmentContactBinding fragmentContactBinding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentContactBinding = FragmentContactBinding.inflate(getLayoutInflater(), container, false);

        journalNameList = new ArrayList<>();
        journalCodeList = new ArrayList<>();
        countryList = new ArrayList<>();
        fragmentContactBinding.txtDailUK.setOnClickListener(this);
        fragmentContactBinding.txtmail.setOnClickListener(this);
        fragmentContactBinding.buttonNext.setOnClickListener(this);


        journalListViewModel = new ViewModelProvider(this).get(JournalListViewModel.class);
        journalListViewModel.journalList("1",requireActivity());

        // progress bar
        journalListViewModel.getProgressbarObservable().observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                fragmentContactBinding.progressBar.setVisibility(View.VISIBLE);

            } else {
                fragmentContactBinding.progressBar.setVisibility(View.GONE);

            }
        });

        // Alert toast msg
        journalListViewModel.getToastObserver().observe(getViewLifecycleOwner(), message -> {
            Snackbar snackbar = Snackbar.make(fragmentContactBinding.getRoot().getRootView(), message, Snackbar.LENGTH_LONG);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.BLACK);
            snackbar.show();

           // utils.noNetworkAlert(getActivity(),message);
        });

        // get home data
        journalListViewModel.getJournalListRepository().observe(getViewLifecycleOwner(), homeResponse -> {
            List<JournalsListResponse.JournalDetailsBean> journalDetailsBeanList = homeResponse.getJournalDetails();
            List<JournalsListResponse.CountryDetailsBean> countryDetailsBeansList = homeResponse.getCountryDetails();

            journalDetailsBeanArrayList.addAll(journalDetailsBeanList);
            countryDetailsBeanArrayList.addAll(countryDetailsBeansList);
            if (homeResponse.isStatus()) {
                journalNameList.clear();
                journalCodeList.clear();
                countryList.clear();
                journalNameList.add("--Select Journal *--");
                countryList.add("--Select Country *--");
                journalCodeList.add("");


                Log.d(TAG, "onResponse: " + journalDetailsBeanList.size());

                for (JournalsListResponse.JournalDetailsBean trackName : journalDetailsBeanList) {
                    journalNameList.add(trackName.getManagejournal());
                    journalCodeList.add(trackName.getJournal());
                }
                for (JournalsListResponse.CountryDetailsBean trackName : countryDetailsBeansList) {
                    countryList.add(trackName.getPrintableName());

                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_spinner_dropdown_item, journalNameList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                fragmentContactBinding.spinnerJournalList.setAdapter(adapter);

                ArrayAdapter<String> adapter1 = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_spinner_dropdown_item, countryList);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                fragmentContactBinding.spinnerCountryList.setAdapter(adapter1);


            } else {
                journalNameList.clear();
                journalCodeList.clear();
                countryList.clear();
                journalNameList.add("--Select Journal *--");
                countryList.add("--Select Country *--");
                journalNameList.add("No Journals");
                countryList.add("No Countries");
                journalCodeList.add("");
                journalCodeList.add("");
                ArrayAdapter<String> adapter =
                        new ArrayAdapter<>(requireActivity(), android.R.layout.simple_spinner_dropdown_item, journalNameList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                fragmentContactBinding.spinnerJournalList.setAdapter(adapter);

                ArrayAdapter<String> adapter1 =
                        new ArrayAdapter<>(requireActivity(), android.R.layout.simple_spinner_dropdown_item, countryList);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                fragmentContactBinding.spinnerCountryList.setAdapter(adapter1);


            }

            fragmentContactBinding.spinnerJournalList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    journalcode = journalCodeList.get(position).toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


        });
        fragmentContactBinding.spinnerCountryList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                country = countryList.get(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        fragmentContactBinding.spinnerCatList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ucat = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        fragmentContactBinding.spinnerDepartmentList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dept = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return fragmentContactBinding.getRoot();
    }



    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtDailUK:
                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                String temp1 = "tel:" + fragmentContactBinding.txtDailUK.getText().toString();
                intent1.setData(Uri.parse(temp1));
                startActivity(intent1);
                break;
            case R.id.txtmail:
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{fragmentContactBinding.txtmail.getText().toString()});

                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (ActivityNotFoundException ex) {
                    Toast.makeText(requireActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buttonNext:


                fname = Objects.requireNonNull(fragmentContactBinding.editFirst.getText()).toString();
                lname = Objects.requireNonNull(fragmentContactBinding.editLast.getText()).toString();
                email = Objects.requireNonNull(fragmentContactBinding.editEmail.getText()).toString();
                phone = Objects.requireNonNull(fragmentContactBinding.editPhone.getText()).toString();
                message = Objects.requireNonNull(fragmentContactBinding.editAddress.getText()).toString();

                if (fname.isEmpty()) {
                    Toast.makeText(requireActivity(), "Please Enter First Name", Toast.LENGTH_SHORT).show();
                } else if (lname.isEmpty()) {
                    Toast.makeText(requireActivity(), "Please Enter Last Name", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(requireActivity(), "Please Enter Email", Toast.LENGTH_SHORT).show();
                } else if (phone.isEmpty()) {
                    Toast.makeText(requireActivity(), "Please Enter Phone", Toast.LENGTH_SHORT).show();
                }else if (journalcode.isEmpty()) {
                    Toast.makeText(requireActivity(), "Please Select Journal", Toast.LENGTH_SHORT).show();
                }else if (country.isEmpty()) {
                    Toast.makeText(requireActivity(), "Please Select Country", Toast.LENGTH_SHORT).show();
                } else if (ucat.equalsIgnoreCase("--Select Category *--")) {
                    Toast.makeText(requireActivity(), "Please Select Category", Toast.LENGTH_SHORT).show();
                }else if (dept.equalsIgnoreCase("--Select Department *--")) {
                    Toast.makeText(requireActivity(), "Please Select Department", Toast.LENGTH_SHORT).show();
                }else if (message.isEmpty()) {
                    Toast.makeText(requireActivity(), "Please Enter Message", Toast.LENGTH_SHORT).show();
                } else {
                    // progress bar
                    journalListViewModel.getProgressbarObservable().observe(getViewLifecycleOwner(), aBoolean -> {
                        if (aBoolean) {
                            fragmentContactBinding.progressBar.setVisibility(View.VISIBLE);

                        } else {
                            fragmentContactBinding.progressBar.setVisibility(View.GONE);

                        }
                    });
                    journalListViewModel.contactData(journalcode,fname,lname,email,ucat,dept,phone,country,message,requireActivity());
                    journalListViewModel.getContactRepository().observe(getViewLifecycleOwner(), new Observer<ContactResponse>() {
                        @Override
                        public void onChanged(ContactResponse contactResponse) {
                            if (contactResponse.isStatus()){
                                Toast.makeText(requireContext(), ""+contactResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                //Navigation.findNavController(fragmentContactBinding.getRoot()).navigate(R.id.nav_home);
                                NavOptions navOptions = new NavOptions.Builder().setPopUpTo(R.id.nav_home, true).build();
                                Navigation.findNavController(fragmentContactBinding.getRoot()).navigate(R.id.nav_home, null, navOptions);

                            }else {
                                Toast.makeText(requireActivity(), ""+contactResponse.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

                break;


        }
    }




}