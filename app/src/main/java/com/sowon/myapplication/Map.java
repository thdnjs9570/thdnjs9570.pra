package com.sowon.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Map extends AppCompatActivity implements View.OnClickListener{

    private final int FRAGMENT1 = 1;
    private final int FRAGMENT2 = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        ImageButton btn_first = (ImageButton)findViewById(R.id.btn_maptop);
        ImageButton btn_second = (ImageButton)findViewById(R.id.btn_maptop2);


        btn_first.setOnClickListener(this);
        btn_second.setOnClickListener(this);

        callFragment(FRAGMENT1);

    }

    private void callFragment(int fragment_no) {

        // 프래그먼트 사용을 위해
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (fragment_no){
            case 1:
                // '프래그먼트1' 호출
                MapFragment1 fragment1 = new MapFragment1();
                transaction.replace(R.id.fragment_container,fragment1);
                transaction.commit();
                break;

            case 2:
                // '프래그먼트2' 호출
                MapFragment2 fragment2 = new MapFragment2();
                transaction.replace(R.id.fragment_container, fragment2);
                transaction.commit();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_maptop :
                // '버튼1' 클릭 시 '프래그먼트1' 호출
                callFragment(FRAGMENT1);

                break;

            case R.id.btn_maptop2 :
                // '버튼2' 클릭 시 '프래그먼트2' 호출
                callFragment(FRAGMENT2);
                break;
        }
    }

}

