package com.journals.scitechnol.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.journals.scitechnol.R;
import com.journals.scitechnol.databinding.InpressItemBinding;
import com.journals.scitechnol.model.InPressResponse;

import java.util.List;

import static com.journals.scitechnol.helper.utils.viewInBrowser;

public class InPressAdapter extends RecyclerView.Adapter<InPressAdapter.ViewHolder> {

    List<InPressResponse.InpressDetailsBean> modelList;
    Context context;
    public InPressAdapter(List<InPressResponse.InpressDetailsBean> modelList,Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public InPressAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(InpressItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull InPressAdapter.ViewHolder holder, int position) {

        holder.rowItemBinding.txtArtical.setText(modelList.get(position).getArticle());
        holder.rowItemBinding.txtShortJournal.setText(modelList.get(position).getShortjournal());
        holder.rowItemBinding.txtDOI.setText(modelList.get(position).getDoi());
        holder.rowItemBinding.txtName.setText(modelList.get(position).getName());
        holder.rowItemBinding.txtTitle.setText(modelList.get(position).getTitle());

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
        InpressItemBinding rowItemBinding;

        public ViewHolder(@NonNull InpressItemBinding rowItemBinding) {
            super(rowItemBinding.getRoot());
            this.rowItemBinding = rowItemBinding;
        }
    }
}
