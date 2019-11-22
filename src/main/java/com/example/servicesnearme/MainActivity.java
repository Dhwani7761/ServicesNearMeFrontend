package com.example.servicesnearme;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.servicesnearme.AppController.TAG;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button custbtn = (Button) findViewById(R.id.customer);
        custbtn.setOnClickListener(this);

        Button pfbtn = (Button) findViewById(R.id.professional);
        pfbtn.setOnClickListener(this);

        Button abtn = (Button) findViewById(R.id.admin);
        abtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.customer:
                Intent c = new Intent(MainActivity.this, Login.class);
                startActivity(c);
                break;
            case R.id.professional:
                Intent p = new Intent(MainActivity.this, ProfessionalLogin.class);
                startActivity(p);
                break;
            case R.id.admin:
                Intent a = new Intent(MainActivity.this, AdminLogin.class);
                startActivity(a);
                break;
        }
    }
}