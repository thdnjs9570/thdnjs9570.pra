package com.sowon.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //액션바 설정하기//
        //액션바 타이틀 변경하기
        getSupportActionBar().setTitle("sejong");
        //액션바 배경색 변경
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.argb(255, 248, 108, 108)));
        //홈버튼 표시
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        ImageButton notice = (ImageButton) findViewById(R.id.btn_coin);
        notice.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this, // 현재 화면의 제어권자
                        MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);

            }
        });


        ImageButton mapb = (ImageButton) findViewById(R.id.btn_map);
        mapb.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this, // 현재 화면의 제어권자
                        Map.class);
                startActivity(intent);

            }
        });



        ImageButton mypage = (ImageButton) findViewById(R.id.btn_community);
        mypage.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this, // 현재 화면의 제어권자
                        Mypage.class);
                startActivity(intent);

            }

        });



        ImageButton money = (ImageButton) findViewById(R.id.btn_mypage);
        money.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this, // 현재 화면의 제어권자
                        Mypage.class);
                startActivity(intent);
            }


        });

        Button co = (Button) findViewById(R.id.btn_cobuy);
        co.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this, // 현재 화면의 제어권자
                        CobuyActivity.class);
                startActivity(intent);
            }


        });


        hideActionBar();

    }


    //액션바 숨기기
    private void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();
    }
}
