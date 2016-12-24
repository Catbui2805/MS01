package com.example.catbui.ms01.QuanLyThietBi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.catbui.ms01.Home.CustomGridViewAdapter;
import com.example.catbui.ms01.Home.Item;
import com.example.catbui.ms01.R;

import java.util.ArrayList;

public class MainQuanlyThietBi extends AppCompatActivity {

    String Quanlythietbi = "";

    GridView gridViewQl;
    ArrayList<Item> gridArrayQl = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quanly_thiet_bi);

        Intent getValue = getIntent();
        Quanlythietbi = getValue.getStringExtra("tilte");
        setTitle(Quanlythietbi);

        Bitmap naptien = BitmapFactory.decodeResource(this.getResources(), R.drawable.naptien);
        Bitmap kiemtrataikhoan1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.tien1);
        Bitmap kiemtrataikhoan2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.tien2);
        Bitmap kiemtradungluong = BitmapFactory.decodeResource(this.getResources(), R.drawable.personal);
//        Bitmap status = BitmapFactory.decodeResource(this.getResources(), R.drawable.status);
        Bitmap infor = BitmapFactory.decodeResource(this.getResources(), R.drawable.info);

        gridArrayQl.add(new Item(naptien, "Nap tiền cho thiết bị"));
        gridArrayQl.add(new Item(kiemtrataikhoan1, "Khiểm tra tài khoản 1"));
        gridArrayQl.add(new Item(kiemtrataikhoan2, "Khiểm tra tài khoản 2"));
        gridArrayQl.add(new Item(kiemtradungluong, "Khiểm tra dung lượng mạng"));
//        gridArrayQl.add(new Item(status, "Tình trạng thiết bị"));
        gridArrayQl.add(new Item(infor, "Thông tin thiết bị"));

        gridViewQl = (GridView) findViewById(R.id.gridViewQL);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.item_quan_ly, gridArrayQl);
        gridViewQl.setAdapter(customGridAdapter);

        gridViewQl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int select = position;
                switch (select) {
                    case 0:
                        Toast.makeText(getApplicationContext(), select + "", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), select + "", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), select + "", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), select + "", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(), select + "", Toast.LENGTH_SHORT).show();
                        break;

                }
            }


        });
    }
}
