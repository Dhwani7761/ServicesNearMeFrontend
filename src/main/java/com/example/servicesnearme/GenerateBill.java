package com.example.servicesnearme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static com.example.servicesnearme.AppController.TAG;

public class GenerateBill extends Activity implements View.OnClickListener {
    EditText sid;
    EditText cust_email;
    EditText request_cust_name;
    EditText request_cust_contact;
    EditText request_cust_address;
    EditText quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generatebill);

        sid = (EditText) findViewById(R.id.sid) ;
        cust_email = (EditText) findViewById(R.id.cust_email);
        request_cust_name = (EditText) findViewById(R.id.request_cust_name) ;
        request_cust_contact = (EditText) findViewById(R.id.request_cust_contact);
        request_cust_address = (EditText) findViewById(R.id.request_cust_address);
        quantity = (EditText) findViewById(R.id.quantity);

        Button loginbtn = (Button) findViewById(R.id.req);
        loginbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        jsonVolley();
        Intent i = new Intent(GenerateBill.this, Bill.class);
      //  sid = (Long) findViewById(R.id.sid);
       //startActivity(i);
        /*Bundle b = new Bundle();
        b.putLong("sid",sid);
        i.putExtras(b);*/
        startActivity(i);

    }

    private void jsonVolley()
    {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("sid", sid.getText().toString());
        params.put("cust_email", cust_email.getText().toString());
        params.put("request_cust_name", request_cust_name.getText().toString());
        params.put("request_cust_contact", request_cust_contact.getText().toString());
        params.put("request_cust_address", request_cust_address.getText().toString());
        params.put("quantity", quantity.getText().toString());


        String url = Urls.newRequestSaveURL;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, new JSONObject(params), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    String sid = response.getString("sid");
                    String cust_email = response.getString("cust_email");
                    String request_cust_name = response.getString("request_cust_name");
                    String request_cust_contact = response.getString("request_cust_contact");
                    String request_cust_address = response.getString("request_cust_address");
                    String quantity = response.getString("quantity");

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