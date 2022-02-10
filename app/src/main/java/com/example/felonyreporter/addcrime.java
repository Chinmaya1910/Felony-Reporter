package com.example.felonyreporter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class addcrime extends AppCompatActivity {
    private EditText name,state,city,pincode,crimedesc;
    private Spinner spinner;
    private Button submit;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    CrimeRVModal crimeRVModal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcrime);
        name=findViewById(R.id.name2);
        state=findViewById(R.id.state2);
        city=findViewById(R.id.city2);
        pincode=findViewById(R.id.pin2);
        crimedesc=findViewById(R.id.crimedesc);
        spinner=findViewById(R.id.spinner);
        submit=findViewById(R.id.button4);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("crimes");


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1 = name.getText().toString();
                String state1 = state.getText().toString();
                String city1 = city.getText().toString();
                String pincode1 = pincode.getText().toString();
                String spinner1 = spinner.getTransitionName();

                String crimedesc1 = crimedesc.getText().toString();
                String crimeid1 = name1;
                /*HashMap<String, String> crimesMap = new HashMap<>();

                crimesMap.put("name", name1);
                crimesMap.put("city", city1);
                crimesMap.put("state", state1);
                crimesMap.put("crime description", crimedesc1);
                crimesMap.put("crimeid", crimeid1);
                crimesMap.put("category", spinner1);
                crimesMap.put("pinncode", pincode1);*/

                if(name1.isEmpty()||city1.isEmpty()||state1.isEmpty()||pincode1.isEmpty()||crimedesc1.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Entering all fields are mandatory!!!",Toast.LENGTH_SHORT).show();
                }
                else {
                    CrimeRVModal crimeRVModal = new CrimeRVModal(name1, state1, city1, pincode1, crimedesc1, spinner1, crimeid1);

                    databaseReference.child(crimeid1).setValue(crimeRVModal);
                    Toast.makeText(addcrime.this, "Crime Added...", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(addcrime.this, home.class));
                }

            }

        });
    }
}