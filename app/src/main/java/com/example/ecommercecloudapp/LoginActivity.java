package com.example.ecommercecloudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class LoginActivity extends AppCompatActivity {
    EditText loginMail,loginPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginMail=findViewById(R.id.loginMail);
        loginPass=findViewById(R.id.loginPass);

        Backendless.initApp(this, "APP_ID", "YOUR_KEY");

    }

    public void login(View view) {
        String mail = loginMail.getText().toString();
        String pass = loginPass.getText().toString();

        Backendless.UserService.login(mail, pass, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                Toast.makeText(LoginActivity.this, "login success", Toast.LENGTH_SHORT).show();
                Intent in=new Intent(LoginActivity.this,Activity_products.class);
                startActivity(in);

            }

            @Override
            public void handleFault(BackendlessFault fault) {
                if (fault.getCode().equals("3003")) {
                    Toast.makeText(LoginActivity.this, "invalid data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
        public void newUser(View view) {
            Intent in=new Intent(this,MainActivity.class);
            startActivity(in);
        }


}
