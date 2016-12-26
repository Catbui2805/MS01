package com.example.catbui.ms01;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity_XacDinhVitri extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    Button XacDinhViTriXeMay;
    Spinner loaiBanDo;
    int selectTypemap = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_maps__xac_dinh_vitri);
        setContentView(R.layout.map_all);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        XacDinhViTriXeMay = (Button) findViewById(R.id.ViTriXe);
        loaiBanDo = (Spinner) findViewById(R.id.spinner);


        XacDinhViTriXeMay.setOnClickListener(this);

        List<String> categories = new ArrayList<String>();
        categories.add("Chọn loại bản đồ");
        categories.add("Bản đồ hiển thị tên đường");
        categories.add("Bản đồ vệ tinh");
        categories.add("Bản đồ địa hình");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loaiBanDo.setAdapter(dataAdapter);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        XacDinhViTriXe();


        // hien thi vi tri nguoi dung tren ban do
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);



    }

    private void XacDinhViTriXe() {
        LatLng nhaCatBui = new LatLng(20.991985, 105.849278);
        mMap.addMarker(new MarkerOptions().position(nhaCatBui).title("Vị trí xe máy Nguyen Tran").icon(BitmapDescriptorFactory.fromResource(R.drawable.moto)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nhaCatBui, 18));
        // kieu ban do hien thi
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        selectTypemap = position;
    }
    @Override
    public void onClick(View view) {
        int getId = view.getId();
        switch (getId){
            case R.id.ViTriXe:
                XacDinhViTriXe();
                break;
            default:
        }
    }


}
