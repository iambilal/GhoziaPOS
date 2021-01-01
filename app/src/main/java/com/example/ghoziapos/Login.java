package com.example.ghoziapos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText Name,Password;
    private Button loginBtn;
    private String name ="Muhammad Anees", password = "manees1963";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = findViewById(R.id.userName);
        Password = findViewById(R.id.userPassword);
        loginBtn = findViewById(R.id.login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Name.getText().toString().equals("") && Password.getText().toString().equals("")){
                    Toast.makeText(Login.this, "Kindly fill the Blank fields!", Toast.LENGTH_SHORT).show();
                }else{
                    if(Name.getText().toString().equals(name) && Password.getText().toString().equals(password)){
                        startActivity(new Intent(getApplicationContext(),Dashboard.class));
                        finish();
                    }else {
                        Toast.makeText(Login.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
                
            }
        });
    }
}