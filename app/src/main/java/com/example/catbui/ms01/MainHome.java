package com.example.catbui.ms01;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.catbui.ms01.Home.CustomGridViewAdapter;
import com.example.catbui.ms01.Home.Item;
import com.example.catbui.ms01.QuanLyThietBi.MainQuanlyThietBi;
import com.example.catbui.ms01.setting.SettingsActivity;

import java.util.ArrayList;


public class MainHome extends AppCompatActivity {
    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();

    CustomGridViewAdapter customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        setTitle("MS - Motor Security");

        Bitmap BatBaoVe = BitmapFactory.decodeResource(this.getResources(), R.drawable.locked);
        Bitmap TatBaoVe = BitmapFactory.decodeResource(this.getResources(), R.drawable.lockedmo1);
        Bitmap TimXe = BitmapFactory.decodeResource(this.getResources(), R.drawable.timxe);
        Bitmap Vitrihientai = BitmapFactory.decodeResource(this.getResources(), R.drawable.placeholder);
        Bitmap Bando = BitmapFactory.decodeResource(this.getResources(), R.drawable.map);
        Bitmap Thietbi = BitmapFactory.decodeResource(this.getResources(), R.drawable.thietbi);
        Bitmap Caidat = BitmapFactory.decodeResource(this.getResources(), R.drawable.settings);
        Bitmap userIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.personal);


        gridArray.add(new Item(BatBaoVe, "Bật bảo vệ xe"));
        gridArray.add(new Item(TatBaoVe, "Tăt bảo vệ xe"));
        gridArray.add(new Item(TimXe, "Tìm kiếm xe"));
        gridArray.add(new Item(Vitrihientai, "Vị trí hiện tại"));
        gridArray.add(new Item(Bando, "Ứng dụng bản đồ"));
        gridArray.add(new Item(Thietbi, "Quản lý thiết bị"));
        gridArray.add(new Item(Caidat, "Cài đặt"));
        gridArray.add(new Item(userIcon, "Ứng dụng khác"));

        if (!isOnline()) {
            Toast.makeText(getApplicationContext(), "không kết nối với mạng", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "kết nối với mạng", Toast.LENGTH_LONG).show();

        }
        gridView = (GridView) findViewById(R.id.gridviewHome);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int select = position;
                switch (select) {
                    case 0:
                        if (isOnline()) {
                            Toast.makeText(getApplicationContext(), select + "có mạng nên dùng mạng", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), select + "khong co mang nen nhan tin", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 1:
                        if (isOnline()) {
                            Toast.makeText(getApplicationContext(), select + "có mạng nên dùng mạng", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), select + "khong co mang nen nhan tin", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2:
                        if (isOnline()) {
                            Toast.makeText(getApplicationContext(), select + "có mạng nên dùng mạng", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), select + "khong co mang nen nhan tin", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 3:
                        if (isOnline()) {
                            Toast.makeText(getApplicationContext(), select + "có mạng nên dùng mạng", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), select + "khong co mang nen nhan tin", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 4:
                        if (isOnline()) {
                            Toast.makeText(getApplicationContext(), select + "có mạng nên dùng mạng", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), select + "khong co mang nen nhan tin", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 5:
                        Toast.makeText(getApplicationContext(), select + "", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainQuanlyThietBi.class);
                        intent.putExtra("tilte", gridArray.get(select).getTitle());
                        startActivity(intent);
                        break;
                    case 6:
                        Toast.makeText(getApplicationContext(), select + "", Toast.LENGTH_SHORT).show();
                        Intent setting = new Intent(getApplicationContext(), SettingsActivity.class);
                        startActivity(setting);
                        break;
                    case 7:
                        if (isOnline()) {
                            Toast.makeText(getApplicationContext(), select + "có mạng nên dùng mạng", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), select + "khong co mang nen nhan tin", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }
        });
    }

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}

