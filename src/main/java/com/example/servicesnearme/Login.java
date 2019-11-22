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

public class Login extends Activity implements View.OnClickListener {

    EditText email;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.email) ;
        password = (EditText) findViewById(R.id.password) ;
        Button signupbtn = (Button) findViewById(R.id.signupbutton);
        signupbtn.setOnClickListener(this);

        Button changepassbtn = (Button) findViewById(R.id.changepass);
        changepassbtn.setOnClickListener(this);
        Button loginbtn = (Button) findViewById(R.id.loginbutton);
        loginbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.loginbutton:
                Intent i = new Intent(Login.this, Dashboard.class);
                startActivity(i);
                break;
            case R.id.signupbutton:
                Intent s = new Intent(Login.this, SignUp.class);
                startActivity(s);
                break;
            case R.id.changepass:
                Intent c = new Intent(Login.this, ChangePassword.class);
                startActivity(c);
                break;
        }
    }
    private void jsonVolley()
    {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("email", email.getText().toString());
        params.put("password", password.getText().toString());

        String url = Urls.CustomerloginURL;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, new JSONObject(params), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
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