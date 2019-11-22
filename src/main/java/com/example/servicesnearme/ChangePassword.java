package com.example.servicesnearme;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChangePassword extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        Button loginbtn = (Button) findViewById(R.id.changepass1);
        loginbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.loginbutton:
                Intent i = new Intent(ChangePassword.this, Login.class);
                startActivity(i);
                break;
            case R.id.changepass:
                Intent c = new Intent(ChangePassword.this, ProfessionalLogin.class);
                startActivity(c);
                break;
        }
    }
}