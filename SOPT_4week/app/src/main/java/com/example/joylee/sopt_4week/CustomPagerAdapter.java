package com.example.joylee.sopt_4week;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by JoyLee on 2017-04-29.
 */

public class CustomPagerAdapter extends FragmentStatePagerAdapter
{
    int tabCount;

    public CustomPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new Fragment_First();
            case 1:
                return new Fragment_Second();
            case 2:
                return new Fragment_Third();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
