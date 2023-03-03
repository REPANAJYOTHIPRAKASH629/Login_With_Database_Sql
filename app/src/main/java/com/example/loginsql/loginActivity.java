package com.example.loginsql;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {
    EditText username,password;
    Button btnLogin;

    DBHelper myDB;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username= (EditText) findViewById(R.id.loginroll);
        password = (EditText) findViewById(R.id.loginpassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        myDB = new DBHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals("")||pass.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please enter the credentials", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean result = myDB.checkusernamePassword(user,pass);
                    if (result == true)
                    {
                        Intent intent = new Intent(loginActivity.this,HomeActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Inavalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}