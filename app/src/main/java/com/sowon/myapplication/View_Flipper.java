package com.sowon.myapplication;

/**
 * Created by thdnj on 2017-11-02.
 */


import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

public class View_Flipper extends LinearLayout implements View.OnTouchListener {

    public static int cntIndex= 4; // 뷰플리퍼를 구현할 화면의 갯수
    LinearLayout indexLayout; // 현재 화면의 인덱스를 표현하기 위한 레이아웃
    ImageView[] indexImgs; // 현재 화면의 인덱스를 나타내는 이미지들
    View[] views; // 뷰플리퍼에 사용할 뷰
    ViewFlipper viewFlipper;

    float startX; // 손가락으로 화면을 터치했을 때 x좌표값을 저장하기 위한 변수
    float endX; // 화면에서 손가락을 뗏을 때 x좌표값을 저장하기 위한 변수

    int currentIndex = 0; //현재의 화면 인덱스 값

    public View_Flipper(Context context) {
        super(context);
        init(context);
    }

    public View_Flipper(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        setBackgroundColor(0xffffff);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_flipper, this, true);

        indexLayout = (LinearLayout) findViewById(R.id.screenIdx);
        viewFlipper = (ViewFlipper) findViewById(R.id.flipper);
        viewFlipper.setOnTouchListener(this);

        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.leftMargin = 50;

        indexImgs = new ImageView[cntIndex];
        views = new ImageView[cntIndex];

        //index 이미지와 뷰플리퍼 화면을 만드는 과정
        for(int i=0; i < cntIndex; i++){
            indexImgs[i] = new ImageView(context);

            if (i == currentIndex){
                indexImgs[i].setImageResource(R.drawable.onon);
            }else {
                indexImgs[i].setImageResource(R.drawable.offoff);
            }

            //indexImgs[i].setPadding();
            indexLayout.addView(indexImgs[i], params);

            ImageView currentView = new ImageView(context);
            currentView.setImageResource(R.drawable.notice1+i);
            views[i] = currentView;

            viewFlipper.addView(views[i]);
        }
    }

    //인덱스 이미지를 수정
    public void modifyIndex(){
        for(int i = 0; i <cntIndex; i++){
            if(i == currentIndex) {
                indexImgs[i].setImageResource(R.drawable.onon);
            }else{
                indexImgs[i].setImageResource(R.drawable.offoff);
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(v != viewFlipper) return false;

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            startX = event.getX();
        } else if(event.getAction() == MotionEvent.ACTION_UP){
            endX = event.getX();
            if(startX < endX){ // 왼쪽에서 오른쪽으로 터치
                //viewFlipper에 애니메이션 설정
                viewFlipper.setInAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.left_in));
                viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.right_out));

                //인덱스체크 - 첫번째화면이면 동작없음
                if(currentIndex > 0){
                    viewFlipper.showPrevious();
                    currentIndex--;
                    modifyIndex();
                }
            } else if(startX > endX){ // 오른쪽에서 왼쪽으로 터치
                viewFlipper.setInAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.right_in));
                viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.left_out));

                //인덱스체크 - 마지막화면이면 동작없음
                if(currentIndex < (cntIndex-1)){
                    viewFlipper.showNext();
                    currentIndex++;
                    modifyIndex();
                }
            }
        }
        return true;
    }
}