package com.sowon.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by thdnj on 2017-11-09.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    // Count number of tabs
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        // Returning the current tabs
        switch (position) {
            case 0:
                CobuyFragment1 tabFragment1 = new CobuyFragment1();
                return tabFragment1;
            case 1:
                CobuyFragment2 tabFragment2 = new CobuyFragment2();
                return tabFragment2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}

