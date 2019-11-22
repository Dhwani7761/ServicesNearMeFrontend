package com.example.servicesnearme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfessionalLogin extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plogin);

        Button psignupbtn = (Button) findViewById(R.id.psignupbutton);
        psignupbtn.setOnClickListener(this);

        Button pchangepassbtn = (Button) findViewById(R.id.pchangepass);
        pchangepassbtn.setOnClickListener(this);
        Button ploginbtn = (Button) findViewById(R.id.ploginbutton);
        ploginbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ploginbutton:
                Intent i = new Intent(ProfessionalLogin.this, Request.class);
                startActivity(i);
                break;
            case R.id.psignupbutton:
                Intent s = new Intent(ProfessionalLogin.this, ProfessionalSignUp.class);
                startActivity(s);
                break;
            case R.id.pchangepass:
                Intent c = new Intent(ProfessionalLogin.this, ChangePassword.class);
                startActivity(c);
                break;
        }
    }
}
