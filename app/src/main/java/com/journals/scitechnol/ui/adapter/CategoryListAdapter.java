package com.journals.scitechnol.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.journals.scitechnol.R;
import com.journals.scitechnol.databinding.CatgeogryListItemBinding;
import com.journals.scitechnol.databinding.CurrentIssueItemBinding;
import com.journals.scitechnol.model.CategoryResponse;


import java.util.List;



public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

    List<CategoryResponse.SubcatDetailsBean> modelList;

    Context context;
    public CategoryListAdapter(List<CategoryResponse.SubcatDetailsBean> modelList,Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(CatgeogryListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListAdapter.ViewHolder holder, int position) {

        holder.rowItemBinding.txtCategoryTitle.setText(modelList.get(position).getJournalName());


        holder.rowItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("journal", modelList.get(position).getJournal());
                bundle.putString("track_paper", modelList.get(position).getTrackPaper());
                bundle.putString("actionBarTitle", modelList.get(position).getJournalName());
                Navigation.findNavController(v).navigate(R.id.dashBoardFragment,bundle);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CatgeogryListItemBinding rowItemBinding;

        public ViewHolder(@NonNull CatgeogryListItemBinding rowItemBinding) {
            super(rowItemBinding.getRoot());
            this.rowItemBinding = rowItemBinding;
        }
    }
}
