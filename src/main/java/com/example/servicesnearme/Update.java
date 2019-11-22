package com.example.servicesnearme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static com.example.servicesnearme.AppController.TAG;

public class Update extends Activity implements View.OnClickListener {

    EditText address;
    EditText landmark;
    EditText area;
    EditText pincode;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        address = (EditText) findViewById(R.id.address) ;
        landmark = (EditText) findViewById(R.id.landmark) ;
        area = (EditText) findViewById(R.id.area) ;
        pincode = (EditText) findViewById(R.id.pincode) ;
        email = (EditText) findViewById(R.id.email) ;
        Button updatebtn = (Button) findViewById(R.id.update);
        updatebtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        jsonVolley();
        Intent i = new Intent(Update.this, Dashboard.class);
        startActivity(i);
    }

    private void jsonVolley()
    {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("address", address.getText().toString());
        params.put("landmark", landmark.getText().toString());
        params.put("area", area.getText().toString());
        params.put("pincode", pincode.getText().toString());
        params.put("email", email.getText().toString());

        String url = Urls.updateCustomerAddress;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, new JSONObject(params), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    String address = response.getString("address");
                    String landmark = response.getString("landmark");
                    String area = response.getString("area");
                    String pincode = response.getString("pincode");
                    String email = response.getString("email");

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

}

