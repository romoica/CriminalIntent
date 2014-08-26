package com.bignerdranch.android.criminalintent;

import android.app.ListFragment;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by RoM on 26.08.2014.
 */
public class CrimeListFragment extends ListFragment {

    private static final String TAG = "CrimeListFragment";
    private List<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);
        mCrimes = CrimeLab.getInstance(getActivity()).getCrimes();
       /* ArrayAdapter<Crime> adapter =
                new ArrayAdapter<Crime>(
                        getActivity(),
                        android.R.layout.simple_list_item_1,
                        mCrimes);*/
        setListAdapter(new CrimeAdapter(mCrimes));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Crime c = (Crime)getListAdapter().getItem(position);
        Log.i(TAG, c.getTitle() + " was clicked");
    }

    private class CrimeAdapter extends ArrayAdapter<Crime> {

        public CrimeAdapter(List<Crime> crimes) {
            super(getActivity(), 0, crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // if we weren't given a view, inflate one
            if (convertView == null) {
                convertView =
                        getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
            }
            // Configure the view for this crime
            Crime c = getItem(position);
            TextView titleTextView =
                    (TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);
            titleTextView.setText(c.getTitle());

            TextView dateTextView =
                    (TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
            dateTextView.setText(DateFormat.format("EEEE, MMM dd, yyyy", c.getDate()));

            CheckBox solvedCheckBox =
                    (CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            solvedCheckBox.setSelected(c.isSolved());

            return convertView;
        }
    }
}
