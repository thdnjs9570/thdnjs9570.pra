package com.sowon.myapplication;

/**
 * Created by thdnj on 2017-11-09.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CobuyFragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_cobuyfragment2, container, false);


        return v;
    }

    public static CobuyFragment2 newInstance(String text) {

        CobuyFragment2 f = new CobuyFragment2();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}
