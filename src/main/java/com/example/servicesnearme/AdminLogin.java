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

public class AdminLogin extends Activity implements View.OnClickListener {
    EditText name;

    EditText password;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alogin);
        name = (EditText) findViewById(R.id.name) ;

        password = (EditText) findViewById(R.id.password) ;
        email = (EditText) findViewById(R.id.email) ;

        Button loginbtn = (Button) findViewById(R.id.aloginbutton);
        loginbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        jsonVolley();

        //switch (v.getId()) {
            //case R.id.aloginbutton:
                Intent i = new Intent(AdminLogin.this, AdminRequest.class);
                startActivity(i);
                //break;
        //}
    }

    private void jsonVolley()
    {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("name", name.getText().toString());
        params.put("password", password.getText().toString());
        params.put("email", email.getText().toString());

        String url = Urls.newAdminSaveURL;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, new JSONObject(params), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    String name = response.getString("name");
                    String password = response.getString("password");
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