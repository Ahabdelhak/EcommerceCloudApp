package com.example.ecommercecloudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class MainActivity extends AppCompatActivity implements AsyncCallback<BackendlessUser> {


    EditText mailText, nameText, passText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mailText = findViewById(R.id.mailText);
        nameText = findViewById(R.id.nameText);
        passText = findViewById(R.id.passText);


        //Backendless.initApp(this, "4403984C-4C60-9F32-FF9E-8BDBB0D02300", "0ECB09C0-67A3-EA29-FF34-899DAE655A00");

    }


    public void signup(View view) {

        BackendlessUser user = new BackendlessUser();
        user.setEmail(mailText.getText().toString());
        user.setPassword(passText.getText().toString());
        user.setProperty("name", nameText.getText().toString());


        Backendless.UserService.register(user, this);


    }

    @Override
    public void handleResponse(BackendlessUser response) {
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void handleFault(BackendlessFault fault) {

        if (fault.getCode().equals("3033")) {
            Toast.makeText(this, "user exists", Toast.LENGTH_SHORT).show();
        }

    }
}
