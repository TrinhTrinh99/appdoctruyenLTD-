package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appdoctruyen.database.Databasedoctruyen;
import com.example.appdoctruyen.model.Truyen;

public class MainDangBai extends AppCompatActivity {
    private EditText edtTenTruyen, edtNoiDung, edtHinhAnh;
    private Button btndangbai,btnhuy;
    private Databasedoctruyen databasedoctruyen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dang_bai);
        anhXa();
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainDangBai.this,MainAdmin.class);
                startActivity(intent);
            }
        });
        btndangbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TenTruyen =edtTenTruyen.getText().toString();
                String NoiDung = edtNoiDung.getText().toString();
                String HinhAnh = edtHinhAnh.getText().toString();
                Truyen truyen = Createtruyen();

                if(TenTruyen.equals("")||NoiDung.equals("")||HinhAnh.equals("")){
                    Toast.makeText(MainDangBai.this,"Yêu cầu nhập đủ thông tin ",Toast.LENGTH_SHORT).show();
                    Log.e("Error ","Không thể tạo mới truyện");
                }else {
                    databasedoctruyen.AddTruyen(truyen);
                    Intent i = new Intent(MainDangBai.this,MainAdmin.class);

                    Toast.makeText(MainDangBai.this,"Tạo truyện thành công",Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(i);
                }

            }
        });
    }


    private void anhXa() {
        edtHinhAnh = (EditText) findViewById(R.id.edtdbhinhanh);
        edtNoiDung = (EditText) findViewById(R.id.edtdbnoidung);
        edtTenTruyen = (EditText) findViewById(R.id.edtdbtentr);
        btndangbai = (Button) findViewById(R.id.btnsave);
        btnhuy=(Button)findViewById(R.id.btncancel);
        databasedoctruyen = new Databasedoctruyen(this);
    }

    private Truyen Createtruyen() {
        String TenTruyen = edtTenTruyen.getText().toString();
        String NoiDung = edtNoiDung.getText().toString();
        String HinhAnh = edtHinhAnh.getText().toString();
        Intent i = getIntent();
        int id = i.getIntExtra("Id",0);
        Truyen truyen = new Truyen(TenTruyen,NoiDung,HinhAnh,id);
        return truyen;

    }


}