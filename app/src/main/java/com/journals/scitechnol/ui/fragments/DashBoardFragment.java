package com.journals.scitechnol.ui.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.journals.scitechnol.R;
import com.journals.scitechnol.databinding.FragmentDashBoardBinding;
import com.journals.scitechnol.helper.utils;
import com.journals.scitechnol.model.DashBoardModel;
import com.journals.scitechnol.ui.adapter.DashBoardListAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashBoardFragment#} factory method to
 * create an instance of this fragment.
 */
public class DashBoardFragment extends Fragment implements DashBoardListAdapter.DashBoardListener {
    private static final String TAG = "DashBoardFragment";
    FragmentDashBoardBinding fragmentDashBoardBinding;
    String journal,actionBarTitle,track_paper;
    private List<DashBoardModel> dashBoardModelList = new ArrayList<>();


    public DashBoardFragment() {
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
        fragmentDashBoardBinding = FragmentDashBoardBinding.inflate(getLayoutInflater(), container, false);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            journal = getArguments().getString("journal");
            track_paper = getArguments().getString("track_paper");
            actionBarTitle = getArguments().getString("actionBarTitle");

        }
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle(actionBarTitle);

        dashBoardData();

        return fragmentDashBoardBinding.getRoot();
    }

    private void dashBoardData() {
        dashBoardModelList.clear();

        dashBoardModelList.add(new DashBoardModel(getResources().getString(R.string.journal_home_tab)));
        dashBoardModelList.add(new DashBoardModel(getResources().getString(R.string.editorial_board)));
        dashBoardModelList.add(new DashBoardModel(getResources().getString(R.string.in_press_tab)));
        dashBoardModelList.add(new DashBoardModel(getResources().getString(R.string.current_issue_tab)));
        dashBoardModelList.add(new DashBoardModel(getResources().getString(R.string.archive_tab)));
        dashBoardModelList.add(new DashBoardModel(getResources().getString(R.string.submit_manuscript)));
        dashBoardModelList.add(new DashBoardModel(getResources().getString(R.string.contact_us)));

        DashBoardListAdapter dashBoardListAdapter = new DashBoardListAdapter(dashBoardModelList, getActivity(), (dashBoardModel, position) -> onItemClick(dashBoardModel, position));
        fragmentDashBoardBinding.recyclerDashBoard.setAdapter(dashBoardListAdapter);
        dashBoardListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(List<DashBoardModel> dashBoardModel, int position) {

        if (dashBoardModel.get(position).getDashBoardTitle().equalsIgnoreCase(getResources().getString(R.string.journal_home_tab))) {

            Bundle bundle = new Bundle();
            bundle.putString("ActionBarTitle", getResources().getString(R.string.journal_home_tab));
            bundle.putString("journal", journal);
            Log.d(TAG, "onItemClick: "+journal);

            Navigation.findNavController(fragmentDashBoardBinding.getRoot()).navigate(R.id.journalHomeFragment, bundle);

        } else if (dashBoardModel.get(position).getDashBoardTitle().equalsIgnoreCase(getResources().getString(R.string.editorial_board))) {
            Bundle bundle = new Bundle();
            bundle.putString("ActionBarTitle", getResources().getString(R.string.editorial_board));
            bundle.putString("journal", journal);
            Navigation.findNavController(fragmentDashBoardBinding.getRoot()).navigate(R.id.editorialBoardFragment, bundle);

        } else if (dashBoardModel.get(position).getDashBoardTitle().equalsIgnoreCase(getResources().getString(R.string.in_press_tab))) {
            Bundle bundle = new Bundle();
            bundle.putString("ActionBarTitle", getResources().getString(R.string.in_press_tab));
            bundle.putString("journal", journal);


            Navigation.findNavController(fragmentDashBoardBinding.getRoot()).navigate(R.id.inPressFragment, bundle);

        } else if (dashBoardModel.get(position).getDashBoardTitle().equalsIgnoreCase(getResources().getString(R.string.current_issue_tab))) {

            Bundle bundle = new Bundle();
            bundle.putString("ActionBarTitle", getResources().getString(R.string.current_issue_tab));
            bundle.putString("journal", journal);


            Navigation.findNavController(fragmentDashBoardBinding.getRoot()).navigate(R.id.currentIssueFragment, bundle);

        } else if (dashBoardModel.get(position).getDashBoardTitle().equalsIgnoreCase(getResources().getString(R.string.archive_tab))) {
            Bundle bundle = new Bundle();
            bundle.putString("ActionBarTitle", getResources().getString(R.string.archive_tab));
            bundle.putString("journal", journal);

            Navigation.findNavController(fragmentDashBoardBinding.getRoot()).navigate(R.id.archiveFragment, bundle);

        } else if (dashBoardModel.get(position).getDashBoardTitle().equalsIgnoreCase(getResources().getString(R.string.submit_manuscript))) {
            utils.viewInBrowser(requireContext(), track_paper, "No data");
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("ActionBarTitle", getResources().getString(R.string.contact_us));
            Navigation.findNavController(fragmentDashBoardBinding.getRoot()).navigate(R.id.journalContactFragment, bundle);

        }

    }


}