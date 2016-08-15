package com.gijbelssiemen.herexamen.Adapter;

/**
 * Created by siemengijbels on 8/11/16.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.gijbelssiemen.herexamen.TabFragments.TabFragment1;
import com.gijbelssiemen.herexamen.TabFragments.TabFragment2;
import com.gijbelssiemen.herexamen.TabFragments.TabFragment3;
import com.gijbelssiemen.herexamen.TabFragments.TabFragment4;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragment1 tab1 = new TabFragment1();
                return tab1;
            case 1:
                TabFragment2 tab2 = new TabFragment2();
                return tab2;
            case 2:
                TabFragment3 tab3 = new TabFragment3();
                return tab3;
            case 3:
                TabFragment4 tab4 = new TabFragment4();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}