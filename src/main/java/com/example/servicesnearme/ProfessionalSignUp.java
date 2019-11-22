package com.example.servicesnearme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class ProfessionalSignUp extends Activity implements View.OnClickListener {

    EditText firstname;
    EditText lastname;
    EditText email;
    EditText password;
    EditText sid;
    EditText areaOfExpertise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psignup);

        firstname = (EditText) findViewById(R.id.firstname);
        lastname = (EditText) findViewById(R.id.lastname) ;
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        sid = (EditText) findViewById(R.id.sid);
        areaOfExpertise = (EditText) findViewById(R.id.areaofExpertise);
        Button loginbtn = (Button) findViewById(R.id.psignupbutton);
        loginbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        jsonVolley();
        Intent i = new Intent(ProfessionalSignUp.this, ProfessionalLogin.class);
        startActivity(i);

    }
    private void jsonVolley()
    {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("firstname", firstname.getText().toString());
        params.put("lastname", lastname.getText().toString());
        params.put("password", password.getText().toString());
        params.put("email", email.getText().toString());
        params.put("areaOfExpertise", areaOfExpertise.getText().toString());
        params.put("sid", sid.getText().toString());
        String url = Urls.newProfessionalURL;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, new JSONObject(params), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    String firstname = response.getString("firstname");
                    String lastname = response.getString("lastname");
                    String password = response.getString("password");
                    String email = response.getString("email");
                    String areaOfExpertise = response.getString("areaOfExpertise");
                    long sid = response.getLong("sid");

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
