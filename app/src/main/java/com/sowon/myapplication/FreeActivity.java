package com.sowon.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class FreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) { //툴바가 있을경우 툴바를 액션바로 지정
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(false);
        }
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));

       getWindow().setStatusBarColor(Color.rgb(248,123,0));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu); // 해당 xml 파일에 저장된 메뉴가 화면에 보여지게됨, 클릭시 동작은 onOptionsItemSelected에서 처리
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //기본메소드
        int id = item.getItemId();


        switch (id) { // 각항목에 대해서 토스트 출력
            case R.id.menu_refresh:
                Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}