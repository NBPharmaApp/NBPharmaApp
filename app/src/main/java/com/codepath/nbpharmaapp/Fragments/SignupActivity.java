package com.codepath.nbpharmaapp.Fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.codepath.nbpharmaapp.R;

class SigupActivity extends AppCompatActivity {
    private EditText et_name, et_firstname, et_email, et_username,
            et_phone, et_password, et_cpassword;
    private String name, firstname, email, phone, password, cpassword, username;
    Button Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        et_username = (EditText) findViewById(R.id.etUserN) ;
        et_name = (EditText) findViewById(R.id.name);
        et_firstname = (EditText) findViewById(R.id.firstname);
        et_phone = (EditText) findViewById(R.id.etPhone);
        et_email = (EditText) findViewById(R.id.email);
        et_password = (EditText) findViewById(R.id.etPassword);
        et_cpassword = (EditText) findViewById(R.id.etCPassword);
        Signup = (Button) findViewById(R.id.btnSignup);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //appel lors d'un click
                signup();
            }
        });
    }
    public void signup(){
        // initialise les variables d'entrer
        initialize();
        if (!validate()){
            Toast.makeText(this,"connection Echouée", Toast.LENGTH_SHORT).show();
        }
        else{
            onSignupSucces();

        }
    }
    public void onSignupSucces(){

    }
    public boolean validate(){
        boolean valid = true;
        if (name.isEmpty()|| name.length()>32){
            et_name.setError("Entrer un nom valide");
            valid = false;
        }
        if (email.isEmpty()|| Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            et_email.setError("Entrer un email valide");
            valid=false;
        }
        return valid;
    }

    public void  initialize(){
        username= et_username.getText().toString().trim();
        name = et_name.getText().toString().trim();
        firstname = et_firstname.getText().toString().trim();
        phone = et_phone.getText().toString().trim();
        email = et_email.getText().toString().trim();
        password = et_password.getText().toString().trim();
        cpassword = et_cpassword.getText().toString().trim();
    }
}

