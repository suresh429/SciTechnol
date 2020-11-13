package com.journals.scitechnol.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.journals.scitechnol.R;
import com.journals.scitechnol.databinding.RecentPublicationsBinding;
import com.journals.scitechnol.model.HomeResponse;

import java.util.List;

import static com.journals.scitechnol.helper.utils.viewInBrowser;


public class RecentPublicationsAdapter extends RecyclerView.Adapter<RecentPublicationsAdapter.ViewHolder> {

    List<HomeResponse.RecentPublicationsBean> modelList;
    Context context;

    public RecentPublicationsAdapter(List<HomeResponse.RecentPublicationsBean> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecentPublicationsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(RecentPublicationsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecentPublicationsAdapter.ViewHolder holder, int position) {

        holder.rowItemBinding.txtArticle.setText(modelList.get(position).getArticle());
        holder.rowItemBinding.txtShortJournal.setText(modelList.get(position).getShortjournal());
        holder.rowItemBinding.txtIssueTitle.setText(modelList.get(position).getTitle());
        holder.rowItemBinding.txtIssueAuthor.setText(Html.fromHtml(modelList.get(position).getName()));

        if (modelList.get(position).getAbsLink() != null && !modelList.get(position).getAbsLink().equalsIgnoreCase("null") && !modelList.get(position).getAbsLink().isEmpty() ) {
            holder.rowItemBinding.txtAbstract.setVisibility(View.VISIBLE);
        } else {
            holder.rowItemBinding.txtAbstract.setVisibility(View.GONE);
        }

        if (modelList.get(position).getPdflink() != null && !modelList.get(position).getPdflink().equalsIgnoreCase("null") && !modelList.get(position).getPdflink().isEmpty() ) {
            holder.rowItemBinding.txtPDF.setVisibility(View.VISIBLE);
        } else {
            holder.rowItemBinding.txtPDF.setVisibility(View.GONE);
        }
        if (modelList.get(position).getFulltextlink() != null && !modelList.get(position).getFulltextlink().equalsIgnoreCase("null") && !modelList.get(position).getFulltextlink().isEmpty() ) {
            holder.rowItemBinding.txtFullText.setVisibility(View.VISIBLE);
        } else {
            holder.rowItemBinding.txtFullText.setVisibility(View.GONE);
        }

        holder.rowItemBinding.txtAbstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("abstractlink", modelList.get(position).getAbsLink());
                bundle.putString("ActionBarTitle","Abstract");


                Navigation.findNavController(v).navigate(R.id.abstractDisplayFragment,bundle);
            }
        });

        holder.rowItemBinding.txtPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewInBrowser(context,modelList.get(position).getPdflink(),"Not Found");
            }
        });

        holder.rowItemBinding.txtFullText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewInBrowser(context,modelList.get(position).getFulltextlink(),"Not Found");
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
        RecentPublicationsBinding rowItemBinding;

        public ViewHolder(@NonNull RecentPublicationsBinding rowItemBinding) {
            super(rowItemBinding.getRoot());
            this.rowItemBinding = rowItemBinding;
        }
    }


}
