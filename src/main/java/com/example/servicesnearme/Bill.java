package com.example.servicesnearme;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
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

import static com.example.servicesnearme.AppController.TAG;

public class Bill extends AppCompatActivity
{
     TextView name = (TextView) findViewById(R.id.name);
   final TextView contact = (TextView) findViewById(R.id.contact);
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

    }
    public void onClick(View v)
    {
        jsonVolley();
        Intent i = new Intent(Bill.this, Dashboard.class);
        startActivity(i);

    }
    private void jsonVolley()
    {
        String url = Urls.generateBillURL + "?rid=63";
       StringRequest request = new StringRequest(Request.Method.GET,
                url,  new Response.Listener<String>() {

           @Override
           public void onResponse(String response) {
               // Display the first 500 characters of the response string.

               name.setText("Response is: "+ response.substring(0,500));
           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               System.out.println("Error");
           }
       });

        AppController.getInstance().addToRequestQueue(request);
    }
}