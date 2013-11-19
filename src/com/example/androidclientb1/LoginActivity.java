package com.example.androidclientb1;

import android.app.Activity;
import android.content.*;
import android.os.Bundle;
import android.widget.*;
import android.view.*;


public class LoginActivity extends Activity {
    Button btnLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnLogin = (Button)
                findViewById (R.id.btnLogin);



        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {



                Intent trocatela = new
                        Intent(LoginActivity.this,UserActivity.class);
                LoginActivity.this.startActivity(trocatela);
                LoginActivity.this.finish();

            }
        });


    }
}
