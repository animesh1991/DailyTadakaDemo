package com.animesh.dailytadkarecipes.recepies.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.animesh.dailytadkarecipes.R;
import com.animesh.dailytadkarecipes.databinding.RowRecipesListBinding;
import com.animesh.dailytadkarecipes.model.RecipeResponse;
import com.animesh.dailytadkarecipes.recepies.interactors.RecipeInteractor;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private Context mContext;
    private List<RecipeResponse> recipeResponses;
    private RecipeInteractor recipeInteractor;

    public RecipeAdapter(Context mContext, RecipeInteractor recipeInteractor, List<RecipeResponse> recipeResponses) {
        this.mContext = mContext;
        this.recipeInteractor = recipeInteractor;
        this.recipeResponses = recipeResponses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowRecipesListBinding rowRecipesListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_recipes_list, parent, false);
        return new ViewHolder(rowRecipesListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setBindingData(recipeResponses.get(position));
    }

    @Override
    public int getItemCount() {
        return recipeResponses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RowRecipesListBinding rowRecipesListBinding;

        public ViewHolder(RowRecipesListBinding itemView) {
            super(itemView.getRoot());
            rowRecipesListBinding = itemView;
            itemView.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recipeInteractor.onRecipeClick(getAdapterPosition());
                }
            });
        }


        public void setBindingData(RecipeResponse recipeResponse) {
            rowRecipesListBinding.setVariable(BR.recipedata, recipeResponse);
        }
    }


}
