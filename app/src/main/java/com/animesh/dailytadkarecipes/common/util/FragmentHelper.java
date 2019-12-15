package com.animesh.dailytadkarecipes.common.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.animesh.dailytadkarecipes.R;

public class FragmentHelper {

    public static void addFragment(int container, Fragment fragment, FragmentManager fragmentManager) {
        fragmentManager.beginTransaction().add(container, fragment).addToBackStack(null).commit();
    }

    public static void replaceFragment(int container, Fragment fragment, FragmentManager fragmentManager) {
        fragmentManager.beginTransaction().replace(container, fragment).commit();
    }

    public static void replaceFragmentBackStack(int container, Fragment fragment, FragmentManager fragmentManager) {
        String backStackName = fragment.getClass().getName();
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)
                .add(container, fragment).addToBackStack(backStackName).commit();
    }

}
