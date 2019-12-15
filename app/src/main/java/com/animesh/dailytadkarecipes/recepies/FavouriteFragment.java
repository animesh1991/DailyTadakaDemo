package com.animesh.dailytadkarecipes.recepies;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.animesh.dailytadkarecipes.R;
import com.animesh.dailytadkarecipes.common.activities.BaseActivity;
import com.animesh.dailytadkarecipes.common.fragments.BaseFragment;

import butterknife.ButterKnife;


public class FavouriteFragment extends BaseFragment {

    public FavouriteFragment() {
        // Required empty public constructor
    }

    public static FavouriteFragment newInstance() {
        return new FavouriteFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = super.onCreateView(inflater,container,savedInstanceState);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    protected int getResId() {
        return R.layout.fragment_favourite;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null)
            ((BaseActivity) getActivity()).showToolBar("Favourite Stories");

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
