package com.bignerdranch.android.criminalintent;

import android.app.Fragment;

/**
 * Created by RoM on 26.08.2014.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
