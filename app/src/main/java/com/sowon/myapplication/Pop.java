package com.sowon.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


public class Pop extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pop);

        TextView textview = (TextView) findViewById(R.id.titletext);
        ImageView img= (ImageView) findViewById(R.id.imageview);


        Intent intent1 = getIntent();
        int attribute = intent1.getExtras().getInt("attribute");
        switch (attribute) {
            case 1:
                textview.setText("파리바게트");
                img.setImageResource(R.drawable.paba);
                break;

            case 2:
                textview.setText("탐앤탐스");
                img.setImageResource(R.drawable.tomntoms);
                break;

            case 3:
                textview.setText("할리스");
                img.setImageResource(R.drawable.hollys);
                break;

            case 4:
                textview.setText("요거프레소");
                img.setImageResource(R.drawable.yoger);
                break;

            case 5:
                textview.setText("계절밥상");
                img.setImageResource(R.drawable.dogbab);
                break;

            case 6:
                textview.setText("DARTS BAR Bull’s");
                img.setImageResource(R.drawable.dart);
                break;

            case 7:
                textview.setText("J당구클럽");
                img.setImageResource(R.drawable.dang);
                break;

            case 8:
                textview.setText("놀숲");
                img.setImageResource(R.drawable.nol);
                break;

            case 9:
                textview.setText("BY.WON");
                img.setImageResource(R.drawable.bymon);
                break;

            case 10:
                textview.setText("라마르");
                img.setImageResource(R.drawable.lamar);
                break;

            case 11:
                textview.setText("SM프로헤어");
                img.setImageResource(R.drawable.smhair);
                break;

            case 12:
                textview.setText("호리다");
                img.setImageResource(R.drawable.horida);
                break;

            case 13:
                textview.setText("코코레지던스");
                img.setImageResource(R.drawable.coco);
                break;
        }

    }
}
