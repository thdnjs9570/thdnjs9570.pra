package com.sowon.myapplication;

/**
 * Created by thdnj on 2017-10-30.
 */
/*
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> { //리사이클러뷰에서 제공하는 어댑터를 상속
    private static final String TAG = "MyRecyclerAdapter";

    private Context context;
    private List<ViewItem> items;
    private int itemLayout;

    public MyRecyclerAdapter(Context context, List<ViewItem> items, int itemLayout) {
        this.context = context;
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { // 지정된 레이아웃을 가져다가 뷰를 만들고 반환
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) { // onCreateViewHolder에서 만든 뷰를 연동시키는 역할, 홀더에있는 데이터 이미지등을 세팅, 리스너부착
        holder.nKeyID = items.get(position).getnKeyID(); // ViewItem클래스에 들어있는 값을 가져와 세팅
        holder.textName.setText(items.get(position).getTextName());

        holder.textContent.setText(items.get(position).getTextContent());
        holder.textContent2.setText(items.get(position).getTextContent2());
        // holder.image.setImageResource(items.get(position).getImage()); // 새로넣음


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(context, "아이템 롱 클릭" + position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // 화면에 아이템을 어떻게 표시할지에 따라서 뷰홀더의 내용은 달라진다
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public int nKeyID;
        public TextView textName;
        public String strPWD;
        public TextView textContent;
        public TextView textContent2;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            textName = (TextView) itemView.findViewById(R.id.textName);
            textContent = (TextView) itemView.findViewById(R.id.textContent);
            textContent2 = (TextView) itemView.findViewById(R.id.textContent2);
        }
    }

}
*/



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> { //리사이클러뷰에서 제공하는 어댑터를 상속
    private static final String TAG = "MyRecyclerAdapter";

    private Context context;
    private List<ViewItem> items;
    private int itemLayout;

    public MyRecyclerAdapter(Context context, List<ViewItem> items, int itemLayout) {
        this.context = context;
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { // 지정된 레이아웃을 가져다가 뷰를 만들고 반환
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) { // onCreateViewHolder에서 만든 뷰를 연동시키는 역할, 홀더에있는 데이터 이미지등을 세팅, 리스너부착
        holder.nKeyID = items.get(position).getnKeyID(); // ViewItem클래스에 들어있는 값을 가져와 세팅
        holder.textName.setText(items.get(position).getTextName());

        holder.textContent.setText(items.get(position).getTextContent());

        //holder.image.setImageResource(items.get(position).getImage()); // 새로넣음

        //테스트
        holder.textMoney.setText(items.get(position).getTextMoney());

        // 간단하게 사용할때는 리스너를 onBindViewHolder안에 작성하며 코드가 길어질경우 외부로 빼기도 한다
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(context, "아이템 롱 클릭" + position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // 화면에 아이템을 어떻게 표시할지에 따라서 뷰홀더의 내용은 달라진다
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public int nKeyID;
        public TextView textName;
        public String strPWD;
        public TextView textContent;
        //테스느
        public TextView textMoney;

        public ViewHolder(View itemView) {
            super(itemView);
           // image = (ImageView) itemView.findViewById(R.id.image);
            textName = (TextView) itemView.findViewById(R.id.textName);
            textContent = (TextView) itemView.findViewById(R.id.textContent);
            textMoney = (TextView) itemView.findViewById(R.id.textMoney);
        }
    }

}
