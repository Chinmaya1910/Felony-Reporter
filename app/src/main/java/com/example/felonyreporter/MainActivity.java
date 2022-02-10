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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mauth;
    Button login,signup;
    EditText username,password;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);

        mauth=FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("crimes");

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                if (TextUtils.isEmpty(user)) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter email!!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter password!!", Toast.LENGTH_LONG).show();
                    return;
                }

                // signin existing user
                mauth.signInWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(
                            @NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),
                                    "Login successful!!",
                                    Toast.LENGTH_LONG)
                                    .show();
                            Intent i=new Intent(getApplicationContext(),home.class);
                            startActivity(i);
                        }

                        else {

                            // sign-in failed
                            Toast.makeText(getApplicationContext(),
                                    "Login failed!!",
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    }
                });
            }



        });

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),signup.class);
                startActivity(i);
            }
        });
    }
}