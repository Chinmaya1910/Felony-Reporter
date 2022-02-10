package com.example.felonyreporter;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;


public class signup extends AppCompatActivity {
    Button login,signup;
    EditText username,password,confirm,Email;
    private FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);
        Email=findViewById(R.id.editTextTextEmailAddress);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        confirm=findViewById(R.id.password2);

        mauth=FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String email=Email.getText().toString();
                String conf=confirm.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Please enter email!!", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(user)) {
                    Toast.makeText(getApplicationContext(), "Please enter name!!", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(getApplicationContext(), "Please enter password!!", Toast.LENGTH_LONG).show();
                    return;
                }
                if(!pass.equals(conf))
                {
                    Toast.makeText(getApplicationContext(), "passwors don't match!", Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    mauth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(signup.this, home.class);
                                startActivity(i);
                            } else {

                                // Registration failed
                                Toast.makeText(getApplicationContext(), "Registration failed!!", Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //redirect
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}