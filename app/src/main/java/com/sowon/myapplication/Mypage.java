package com.sowon.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by thdnj on 2017-10-29.
 */

public class Mypage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mypage);
        //hideActionBar();
    }

    private void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();
    }

}