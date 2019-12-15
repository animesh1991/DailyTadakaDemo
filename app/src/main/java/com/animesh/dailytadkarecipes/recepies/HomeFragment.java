package com.animesh.dailytadkarecipes.recepies;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.animesh.dailytadkarecipes.R;
import com.animesh.dailytadkarecipes.app.DailyTadka;
import com.animesh.dailytadkarecipes.common.activities.BaseActivity;
import com.animesh.dailytadkarecipes.common.fragments.BaseFragment;
import com.animesh.dailytadkarecipes.common.util.Constants;
import com.animesh.dailytadkarecipes.model.MainMenuModel;
import com.animesh.dailytadkarecipes.recepies.adapters.HomeMenuAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeFragment extends BaseFragment {

    @BindView(R.id.rv_product_list)
    RecyclerView rvProductList;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected int getResId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null)
            ((BaseActivity) getActivity()).showToolBar("DashBoard");
        getMainMenuJson();
    }

    private void getMainMenuJson() {
        String json;
        json = DailyTadka.getInstance().getFirebaseRemoteConfig().getString(Constants.FireBaseRemoteConfig.REMOTE_MAIN_MENU_ENG);
        List<MainMenuModel> mainMenuModels = new Gson().fromJson(json, new TypeToken<List<MainMenuModel>>() {
        }.getType());
        HomeMenuAdapter homeMenuAdapter = new HomeMenuAdapter(getActivity(),mainMenuModels);
        rvProductList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvProductList.setAdapter(homeMenuAdapter);
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
