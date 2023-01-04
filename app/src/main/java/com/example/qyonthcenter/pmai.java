package com.example.qyonthcenter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class pmai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xpmai);

        }


    //menu show
    public boolean onCreateOptionsMenu(Menu q)
    {
        getMenuInflater().inflate(R.menu.qmauu,q);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem qi) {

        int w=qi.getItemId();

        if(w==R.id.qcua)//connect us
        {
            Intent cghs=new Intent(getApplicationContext(),qcont.class);
            startActivity(cghs);
        }

        else
        if(w==R.id.qbopr)//book program
        {

            Intent cghs=new Intent(getApplicationContext(), qboq.class);
            startActivity(cghs);
        }


        else
        if(w==R.id.qcla)//exit
        {
            finish();
        }
        return true;






    }
}