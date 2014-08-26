package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by RoM on 26.08.2014.
 */
public class CrimeLab {

    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private List<Crime> mCrimes = new ArrayList<Crime>();

    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime " + i);
            crime.setSolved(i % 2 == 0);
            mCrimes.add(crime);
        }
    }

    public CrimeLab getInstance(Context c) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }
}
