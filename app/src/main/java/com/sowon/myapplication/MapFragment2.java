package com.sowon.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;


public class MapFragment2 extends Fragment {

    private List<String> list;          // 데이터를 넣은 리스트변수
    private ListView listView;          // 검색을 보여줄 리스트변수
    private EditText editSearch;        // 검색어를 입력할 Input 창
    private SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<String> arraylist;


    public MapFragment2()
    {
        // required
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showMessage();


    }

    private void showMessage() {
// 대화상자를만들기위한빌더객체생성
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());
        builder.setTitle("안내");
        builder.setMessage("     교내 알뜰맵을 통해 각종 편의시설, 물품대여 장소를 찾아보세요!");
        builder.setIcon(R.drawable.megaphone);

        builder.setPositiveButton("X", new DialogInterface.OnClickListener() { // x버튼
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();// 대화상자객체생성후보여주기
        dialog.show();

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.mapfragment_pager2,
                container, false);



        editSearch = (EditText) layout.findViewById(R.id.editSearch);
        listView = (ListView) layout.findViewById(R.id.listView);


        // 리스트를 생성한다.
        list = new ArrayList<String>();

        // 검색에 사용할 데이터을 미리 저장한다.
        settingList();

        // 리스트의 모든 데이터를 arraylist에 복사한다.// list 복사본을 만든다.
        arraylist = new ArrayList<String>();
        arraylist.addAll(list);

        // 리스트에 연동될 아답터를 생성한다.
        adapter = new SearchAdapter(list, this.getActivity());


        // 리스트뷰에 아답터를 연결한다.
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            public void onItemClick(AdapterView parent, View view, int position, long id) {
            if(position==0){
                Intent intent = new Intent(view.getContext(),MainActivity.class);
                startActivity(intent);
            }
            if(position==1){
                Intent intent = new Intent(view.getContext(),MainActivity.class);
                startActivity(intent);
            }
            if(position==2){
                Intent intent = new Intent(view.getContext(),MainActivity.class);
                startActivity(intent);
            }
            // get TextView's Text.
            String strText = (String) parent.getItemAtPosition(position) ;

                                                // TODO : use strText
                                            }
                                        }
        ) ;
        // input창에 검색어를 입력시 "addTextChangedListener" 이벤트 리스너를 정의한다.
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch.getText().toString();
                search(text);
            }
        });

        return layout;
    }


    // 검색을 수행하는 메소드
    public void search(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        // 문자 입력을 할때..
        else
        {
            // 리스트의 모든 데이터를 검색한다.
            for(int i = 0;i < arraylist.size(); i++)
            {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (arraylist.get(i).toLowerCase().contains(charText))
                {
                    // 검색된 데이터를 리스트에 추가한다.
                    list.add(arraylist.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
    }

    // 검색에 사용될 데이터를 리스트에 추가한다.
    private void settingList(){
        list.add("편의시설");
        list.add("헬스장");
        list.add("클라이밍장");
        list.add("카페");
        list.add("등등");
        list.add("등등등");
        list.add("등등등등");
        list.add("물품");
        list.add("우산");
        list.add("무선충전기");
        list.add("담요");
        list.add("돗자리");
        list.add("등등");
        list.add("등등");
        list.add("등등");
        list.add("등등");
        list.add("등등");
    }


}

