package com.animesh.dailytadkarecipes.common.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.animesh.dailytadkarecipes.R;
import com.animesh.dailytadkarecipes.databinding.ActivityBaseBinding;


public abstract class BaseFragment extends Fragment {

    private ActivityBaseBinding activityBaseBinding;
    private ViewDataBinding viewDataBinding;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        activityBaseBinding = DataBindingUtil.inflate(inflater, R.layout.activity_base, container, false);
        viewDataBinding = DataBindingUtil.inflate(inflater, getResId(), activityBaseBinding.flContainerMain, true);
        return activityBaseBinding.getRoot();
    }

    protected abstract int getResId();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
