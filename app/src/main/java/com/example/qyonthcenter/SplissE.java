package com.example.qyonthcenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplissE extends AppCompatActivity {
    Handler qhado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spliss_e);

        setContentView(R.layout.spliss_e);

        qhado=new Handler();
        qhado.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent qinb=new Intent(SplissE.this, pmai.class);
                startActivity(qinb);
                finish();
            }
        },3000);
    }
}