package com.bignerdranch.android.criminalintent;

import android.app.ListFragment;
import android.os.Bundle;

import java.util.List;

/**
 * Created by RoM on 26.08.2014.
 */
public class CrimeListFragment extends ListFragment {

    private List<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);
        mCrimes = CrimeLab.getInstance(getActivity()).getCrimes();
    }
}
