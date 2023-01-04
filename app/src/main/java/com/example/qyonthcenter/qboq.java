package com.example.qyonthcenter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class qboq extends AppCompatActivity {

    Qdatabasee qdbx;//database name
    Button qbtoo1, qbtoo2, qbtoo3, qbtoo4, qbtoo5, qbtoo6;
    EditText nqam,pqhon, eqmai, pqrogra, hqou,  pqris;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qboqx);

        qdbx=new Qdatabasee(this);

        nqam= (EditText) findViewById(R.id.qabv1);//name
        pqhon = (EditText) findViewById(R.id.qabv2);//phone
        eqmai = (EditText) findViewById(R.id.qabv3);//email
        pqrogra = (EditText) findViewById(R.id.qabv4);//program name
        hqou = (EditText) findViewById(R.id.qabv5);//time hours
        pqris= (EditText) findViewById(R.id.qabv6);//total


        qbtoo1 = (Button) findViewById(R.id.qbt1);//adding
        qbtoo2 = (Button) findViewById(R.id.qbt2);//update
        qbtoo3 = (Button) findViewById(R.id.qbt3);//deleat
        qbtoo4 = (Button) findViewById(R.id.qbt4);//view the data
        qbtoo5 = (Button) findViewById(R.id.qbt5);//clear all inters
        qbtoo6= (Button) findViewById(R.id.qbt6);//calculation


        //methods for button
       qadatas(); //add
        qclero();//clear
        qupqdate(); //update
        deletq();//deleat
        qseedatas();//calculation
        qviewd();//view


    }
    //update
    public void qupqdate()
    {
        qbtoo2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean uqpdatqe=qdbx.QUP(nqam.getText().toString(),pqhon.getText().toString(), eqmai.getText().toString(),pqrogra.getText().toString(), hqou.getText().toString(), pqris.getText().toString());
                if(uqpdatqe==true)
                    Toast.makeText(qboq.this,"updated finish",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(qboq.this, "no updated",Toast.LENGTH_LONG).show();
            }
        });
    }
    //delete
    public void deletq()
    {
        qbtoo3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Integer TXP=qdbx.QDL(pqhon.getText().toString());
                if(TXP>0)
                    Toast.makeText(qboq.this,"finish deleted ",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(qboq.this,"didn't deleted",Toast.LENGTH_LONG).show();
            }
        });
    }


    //adding
    public void qadatas()
    {
        qbtoo1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean inqsertq=qdbx.QIN(nqam.getText().toString(),pqhon.getText().toString(), eqmai.getText().toString(),pqrogra.getText().toString(), hqou.getText().toString(), pqris.getText().toString());
                if(inqsertq==true)
                    Toast.makeText(qboq.this, "finish enter data",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(qboq.this,"didn't enter data",Toast.LENGTH_LONG).show();
            }
        });
    }








    //view
    public void qviewd()
    {
        qbtoo4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Cursor qAbahri=qdbx.getAllData();
                if(qAbahri.getCount()==0)
                {
                    showMessage("nothing", "Nothing found");
                    return;
                }
                StringBuffer SM7=new StringBuffer();
                while(qAbahri.moveToNext())
                {

                    SM7.append("full Name:"+qAbahri.getString(0)+"\n");
                    SM7.append("phone: "+qAbahri.getString(1)+"\n");
                    SM7.append("email:"+qAbahri.getString(2)+"\n");
                    SM7.append("program :"+qAbahri.getString(3)+"\n");
                    SM7.append("hours:"+qAbahri.getString(4)+"\n");
                    SM7.append("total price:"+qAbahri.getString(5)+"\n");
                }
                showMessage("all details of clients book",SM7.toString());
            }
        });
    }


    public void qseedatas()//calculation
    {
        qbtoo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nqam.getText().toString().isEmpty()||pqhon.getText().toString().isEmpty()|| eqmai.getText().toString().isEmpty()||pqrogra.getText().toString().isEmpty()|| hqou.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter details",Toast.LENGTH_LONG).show();
                }
                else
                {
                    double PACC=5.500;//prise of place
                    double QHOY= Double.parseDouble(hqou.getText().toString());//convert to double
                    double TCOQ=(PACC * QHOY);//multi
                    pqris.setText(Double.toString(TCOQ));//output

                }

            }
        });
    }


    //clear
    public void qclero()
    {
        qbtoo5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                nqam.setText("");
                pqhon.setText("");
                eqmai.setText("");
                pqrogra.setText("");
                hqou.setText("");
                pqris.setText("");
            }
        });
    }


    //status border
    public void showMessage(String cbv,String smlc)
    {
        AlertDialog.Builder wjnd=new AlertDialog.Builder(this);
        wjnd.setCancelable(true);
        wjnd.setTitle(cbv);
        wjnd.setMessage(smlc);
        wjnd.show();
    }

}
