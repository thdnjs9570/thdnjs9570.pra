package com.sowon.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment1 extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnMapClickListener {

    LatLng start;

    Toolbar myToolbar;
    Spinner mySpinner;

    private MapView mapView = null;
    private GoogleMap mMap;


    private Marker mParis;
    private Marker mTom;
    private Marker mharis;
    private Marker myo;
    private Marker mdog;
    private Marker mdart;
    private Marker mclub;
    private Marker mnols;
    private Marker mwon;
    private Marker mramare;
    private Marker mprohair;
    private Marker mhorida;
    private Marker mcoco;
    private Marker jacehair;
    int sort;


    private static final LatLng PERTH = new LatLng(37.549274, 127.075162);
    private static final LatLng PERTH2 = new LatLng(37.548093, 127.072484);
    private static final LatLng PERTH3 = new LatLng(37.545057, 127.072683);
    private static final LatLng PERTH4 = new LatLng(37.552987, 127.071729);
    private static final LatLng PERTH5 = new LatLng(37.540843, 127.071395);
    private static final LatLng PERTH6 = new LatLng(37.543506, 127.071913);
    private static final LatLng PERTH7 = new LatLng(37.547477, 127.070954);
    private static final LatLng PERTH8 = new LatLng(37.544754, 127.072544);
    private static final LatLng PERTH9 = new LatLng(37.542483, 127.071460);
    private static final LatLng PERTH10 = new LatLng(37.540791, 127.067702);
    private static final LatLng PERTH11 = new LatLng(37.544951, 127.071749);
    private static final LatLng PERTH12 = new LatLng(37.543943, 127.072186);
    private static final LatLng PERTH13 = new LatLng(37.554309, 127.074648);
    private int REQUEST_TEST = 1;

    public MapFragment1() {
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
        builder.setMessage("     교외 알뜰맵을 통해 세종대생만의 할인혜택 장소를 찾아보세요!");
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
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.mapfragment_pager1, container, false);

        mapView = (MapView) layout.findViewById(R.id.map);
        mapView.getMapAsync(this);


        myToolbar = (Toolbar) layout.findViewById(R.id.toolbar);
        mySpinner = (Spinner) layout.findViewById(R.id.spinner);


        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getItemAtPosition(i).toString();
                if (selectedItem.equals("카테고리")) {
                    Toast.makeText(getActivity(), mySpinner.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

                    setAllgone();
                    mParis.setVisible(true);
                    mTom.setVisible(true);
                    mharis.setVisible(true);
                    myo.setVisible(true);
                    mdog.setVisible(true);
                    mdart.setVisible(true);
                    mclub.setVisible(true);
                    mnols.setVisible(true);
                    mwon.setVisible(true);
                    mramare.setVisible(true);
                    mprohair.setVisible(true);
                    mhorida.setVisible(true);
                    mcoco.setVisible(true);

                }
                if (selectedItem.equals("푸드")) {
                    Toast.makeText(getActivity(), mySpinner.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

                    setAllgone();
                    mParis.setVisible(true);
                    mTom.setVisible(true);
                    mharis.setVisible(true);
                    myo.setVisible(true);
                    mdog.setVisible(true);
                    mdart.setVisible(true);

                }
                if (selectedItem.equals("문화")) {

                    setAllgone();
                    mclub.setVisible(true);
                    mnols.setVisible(true);

                }
                if (selectedItem.equals("뷰티")) {

                    setAllgone();
                    mwon.setVisible(true);
                    mramare.setVisible(true);
                    mprohair.setVisible(true);
                    mhorida.setVisible(true);

                }
                if (selectedItem.equals("기타")) {
                    setAllgone();
                    mcoco.setVisible(true);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return layout;
    }


    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onLowMemory();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //액티비티가 처음 생성될 때 실행되는 함수

        if (mapView != null) {
            mapView.onCreate(savedInstanceState);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        start = new LatLng(37.54790500000001, 127.07459300000005); //학교에 대한 위치 설정


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(start, 16)); //맵 시작화면 확대하기


        // 구글 맵에 표시할 마커에 대한 옵션 설정


        MarkerOptions makerOptions = new MarkerOptions();
        makerOptions
                .position(start)
                .title("세종대학교");


        switch (sort) {
            case 1:
                break;
        }

        mParis = mMap.addMarker(new MarkerOptions()
                .position(PERTH)
                .title("파리바게트")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_place4)));



        mTom = mMap.addMarker(new MarkerOptions()
                .position(PERTH2)
                .title("탐앤탐스")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_place4)));


        mharis = mMap.addMarker(new MarkerOptions()
                .position(PERTH3)
                .title("할리스")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_place4)));


        myo = mMap.addMarker(new MarkerOptions()
                .position(PERTH4)
                .title("요거프레소")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_place4)));


        mdog = mMap.addMarker(new MarkerOptions()
                .position(PERTH5)
                .title("계절밥상")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_place4)));

        mdart = mMap.addMarker(new MarkerOptions()
                .position(PERTH6)
                .title("DARTS BAR Bull’s")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_place4)));


        mclub = mMap.addMarker(new MarkerOptions()
                .position(PERTH7)
                .title("J당구클럽")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_place2)));


        mnols = mMap.addMarker(new MarkerOptions()
                .position(PERTH8)
                .title("놀숲")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_place2)));


        mwon = mMap.addMarker(new MarkerOptions()
                .position(PERTH9)
                .title("BY.WON")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_place1)));


        mramare = mMap.addMarker(new MarkerOptions()
                .position(PERTH10)
                .title("라마르")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_place1)));

        mprohair = mMap.addMarker(new MarkerOptions()
                .position(PERTH11)
                .title("SM프로헤어")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_place1)));

        mhorida = mMap.addMarker(new MarkerOptions()
                .position(PERTH12)
                .title("호리다")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_place1)));

        mcoco = mMap.addMarker(new MarkerOptions()
                .position(PERTH13)
                .title("코코레지던스")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_place3)));


        // 마커를 생성한다.
        mMap.addMarker(makerOptions);

        //카메라를 학교 위치로 옮긴다.
        mMap.moveCamera(CameraUpdateFactory.newLatLng(start));


        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

            @Override
            public void onInfoWindowClick(Marker arg0) {


                if (arg0 != null && arg0.getTitle().equals("파리바게트")) {
                    Intent intent1 = new Intent(getActivity(), Pop.class);
                    intent1.putExtra("attribute", 1);
                    startActivity(intent1);
                }

                if (arg0 != null && arg0.getTitle().equals("탐앤탐스")) {
                    Intent intent1 = new Intent(getActivity(), Pop.class);
                    intent1.putExtra("attribute", 2);
                    startActivity(intent1);
                }

                if (arg0 != null && arg0.getTitle().equals("할리스")) {
                    Intent intent1 = new Intent(getActivity(), Pop.class);
                    intent1.putExtra("attribute", 3);
                    startActivity(intent1);
                }

                if (arg0 != null && arg0.getTitle().equals("요거프레소")) {
                    Intent intent1 = new Intent(getActivity(), Pop.class);
                    intent1.putExtra("attribute", 4);
                    startActivity(intent1);
                }

                if (arg0 != null && arg0.getTitle().equals("계절밥상")) {
                    Intent intent1 = new Intent(getActivity(), Pop.class);
                    intent1.putExtra("attribute", 5);
                    startActivity(intent1);
                }

                if (arg0 != null && arg0.getTitle().equals("DARTS BAR Bull’s")) {
                    Intent intent1 = new Intent(getActivity(), Pop.class);
                    intent1.putExtra("attribute", 6);
                    startActivity(intent1);
                }

                if (arg0 != null && arg0.getTitle().equals("J당구클럽")) {
                    Intent intent1 = new Intent(getActivity(), Pop.class);
                    intent1.putExtra("attribute", 7);
                    startActivity(intent1);
                }

                if (arg0 != null && arg0.getTitle().equals("놀숲")) {
                    Intent intent1 = new Intent(getActivity(), Pop.class);
                    intent1.putExtra("attribute", 8);
                    startActivity(intent1);
                }

                if (arg0 != null && arg0.getTitle().equals("BY.WON")) {
                    Intent intent1 = new Intent(getActivity(), Pop.class);
                    intent1.putExtra("attribute", 9);
                    startActivity(intent1);
                }

                if (arg0 != null && arg0.getTitle().equals("라마르")) {
                    Intent intent1 = new Intent(getActivity(), Pop.class);
                    intent1.putExtra("attribute", 10);
                    startActivity(intent1);
                }

                if (arg0 != null && arg0.getTitle().equals("SM프로헤어")) {
                    Intent intent1 = new Intent(getActivity(), Pop.class);
                    intent1.putExtra("attribute", 11);
                    startActivity(intent1);
                }

                if (arg0 != null && arg0.getTitle().equals("호리다")) {
                    Intent intent1 = new Intent(getActivity(), Pop.class);
                    intent1.putExtra("attribute", 12);
                    startActivity(intent1);
                }

                if (arg0 != null && arg0.getTitle().equals("코코레지던스")) {
                    Intent intent1 = new Intent(getActivity(), Pop.class);
                    intent1.putExtra("attribute", 13);
                    startActivity(intent1);
                }


            }
        });

    }


    @Override
    public void onMapClick(LatLng latLng) {


    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        CameraUpdate center = CameraUpdateFactory.newLatLng(marker.getPosition());
        mMap.animateCamera(center);

        return false;
    }

    public void setAllgone() {
        mParis.setVisible(false);
        mTom.setVisible(false);
        mharis.setVisible(false);
        myo.setVisible(false);
        mdog.setVisible(false);
        mdart.setVisible(false);
        mclub.setVisible(false);
        mnols.setVisible(false);
        mwon.setVisible(false);
        mramare.setVisible(false);
        mprohair.setVisible(false);
        mhorida.setVisible(false);
        mcoco.setVisible(false);
    }

}

