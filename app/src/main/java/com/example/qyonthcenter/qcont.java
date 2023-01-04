package com.example.qyonthcenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
// connect page
public class qcont extends AppCompatActivity {
    Button cx1,cx2,cx3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qcont);

        cx1=(Button) findViewById(R.id.z5);
        cx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bgm=cx1.getText().toString();

                Intent bgmzxc = new Intent(Intent.ACTION_VIEW);
                bgmzxc.setData(Uri.parse("https://yc.om"));
                startActivity(bgmzxc);


            }
        });



        cx2=(Button) findViewById(R.id.z3);
        cx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bgm=cx2.getText().toString();

                Intent bgmzxc = new Intent(Intent.ACTION_VIEW);
                bgmzxc.setData(Uri.parse("https://www.instagram.com/youthcenter_om/"));
                startActivity(bgmzxc);


            }
        });

        cx3=(Button) findViewById(R.id.z4);
        cx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bgm=cx3.getText().toString();

                Intent bgmzxc = new Intent(Intent.ACTION_VIEW);
                bgmzxc.setData(Uri.parse("https://twitter.com/YouthCenter_om"));
                startActivity(bgmzxc);


            }
        });



    }
}