package com.animesh.dailytadkarecipes.recepies.adapters;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.animesh.dailytadkarecipes.R;
import com.animesh.dailytadkarecipes.common.util.Constants;
import com.animesh.dailytadkarecipes.databinding.RowHomeMenuBinding;
import com.animesh.dailytadkarecipes.model.MainMenuModel;
import com.animesh.dailytadkarecipes.recepies.MenuListActivity;

import java.util.List;

public class HomeMenuAdapter extends RecyclerView.Adapter<HomeMenuAdapter.ViewHolder> {

    private List<MainMenuModel> mainMenuModels;
    private Context mContext;

    public HomeMenuAdapter(Context context, List<MainMenuModel> mainMenuModels) {
        this.mContext = context;
        this.mainMenuModels = mainMenuModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowHomeMenuBinding rowHomeMenuBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.row_home_menu, parent, false);
        return new ViewHolder(rowHomeMenuBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(mainMenuModels.get(position));
    }

    @Override
    public int getItemCount() {
        return mainMenuModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        RowHomeMenuBinding rowHomeMenuBinding;

        public ViewHolder(final RowHomeMenuBinding itemView) {
            super(itemView.getRoot());
            rowHomeMenuBinding = itemView;
            itemView.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, MenuListActivity.class);
                    intent.putExtra(Constants.ExtraBundleKeys.KEY_MENU_TAG, mainMenuModels.get(getAdapterPosition()).getMenuCode());
                    mContext.startActivity(intent);
                }
            });
        }

        void bindData(MainMenuModel mainMenuModel) {
            rowHomeMenuBinding.setMenu(mainMenuModel);
        }
    }

}
