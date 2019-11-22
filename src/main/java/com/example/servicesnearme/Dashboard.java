package com.example.servicesnearme;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class Dashboard extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Button homebtn = (Button) findViewById(R.id.home);
        homebtn.setOnClickListener(this);
        Button updatebtn = (Button) findViewById(R.id.up);
        updatebtn.setOnClickListener(this);
        Button sv1 = (Button) findViewById(R.id.service1);
        sv1.setOnClickListener(this);
        Button sv2 = (Button) findViewById(R.id.service2);
        sv2.setOnClickListener(this);
        Button sv3 = (Button) findViewById(R.id.service3);
        sv3.setOnClickListener(this);
        Button sv4 = (Button) findViewById(R.id.service4);
        sv4.setOnClickListener(this);
        Button sv5 = (Button) findViewById(R.id.service5);
        sv5.setOnClickListener(this);
        Button sv6 = (Button) findViewById(R.id.service6);
        sv6.setOnClickListener(this);
        Button sv7 = (Button) findViewById(R.id.service7);
        sv7.setOnClickListener(this);
        Button sv8 = (Button) findViewById(R.id.service8);
        sv8.setOnClickListener(this);
        Button sv9 = (Button) findViewById(R.id.service9);
        sv9.setOnClickListener(this);
        Button sv10 = (Button) findViewById(R.id.service10);
        sv10.setOnClickListener(this);
        Button sv11 = (Button) findViewById(R.id.service11);
        sv11.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.home:
                Intent i = new Intent(Dashboard.this, Dashboard.class);
                startActivity(i);
                break;
            case R.id.up:
                Intent c = new Intent(Dashboard.this, Update.class);
                startActivity(c);
                break;
            case R.id.service1:
                Intent s1 = new Intent(Dashboard.this, GenerateBill.class);
                startActivity(s1);
                break;
            case R.id.service2:
                Intent s2 = new Intent(Dashboard.this, GenerateBill.class);
                startActivity(s2);
                break;
            case R.id.service3:
                Intent s3 = new Intent(Dashboard.this, GenerateBill.class);
                startActivity(s3);
                break;
            case R.id.service4:
                Intent s4 = new Intent(Dashboard.this, GenerateBill.class);
                startActivity(s4);
                break;
            case R.id.service5:
                Intent s5 = new Intent(Dashboard.this, GenerateBill.class);
                startActivity(s5);
                break;
            case R.id.service6:
                Intent s6 = new Intent(Dashboard.this, GenerateBill.class);
                startActivity(s6);
                break;
            case R.id.service7:
                Intent s7 = new Intent(Dashboard.this, GenerateBill.class);
                startActivity(s7);
                break;
            case R.id.service8:
                Intent s8 = new Intent(Dashboard.this, GenerateBill.class);
                startActivity(s8);
                break;
            case R.id.service9:
                Intent s9 = new Intent(Dashboard.this, GenerateBill.class);
                startActivity(s9);
                break;
            case R.id.service10:
                Intent s10 = new Intent(Dashboard.this, GenerateBill.class);
                startActivity(s10);
                break;
            case R.id.service11:
                Intent s11 = new Intent(Dashboard.this, GenerateBill.class);
                startActivity(s11);
                break;

        }
    }
}