package com.example.appdoctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telecom.TelecomManager;
import android.widget.TextView;

public class MainThongTin extends AppCompatActivity {
        TextView txtthongtin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_thong_tin);
        txtthongtin = (TextView)findViewById(R.id.tvthongtin);
        String thongtin ="Ứng dụng được làm bởi nhóm pineapple \n\n"+
                         " Độ tin cậy 100% \n\n"+
                         " Phát hành vào năm 2021 \n\n"+
                         " Mọi ý kiến đóng góp gửi về DiemMy@gmail.com ";
        txtthongtin.setText(thongtin);
    }
}