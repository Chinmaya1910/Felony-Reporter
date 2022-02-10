package com.example.felonyreporter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class addmissingperson extends AppCompatActivity {
    private EditText name,state,city,pincode,image,perdes;
    private Button submit;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    MissingRVModal missingRVModal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmissingperson);
        name=findViewById(R.id.name);
        state=findViewById(R.id.state);
        city=findViewById(R.id.city);
        pincode=findViewById(R.id.pin);
        perdes=findViewById(R.id.desc);
        image=findViewById(R.id.img2);
        submit=findViewById(R.id.button5);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("missing persons");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name2=name.getText().toString();
                String city2=city.getText().toString();
                String state2=state.getText().toString();
                String pincode2=pincode.getText().toString();
                String perdes2=perdes.getText().toString();
                String image2=image.getText().toString();
                if(name2.isEmpty()||city2.isEmpty()||state2.isEmpty()||pincode2.isEmpty()||perdes2.isEmpty()||image2.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Entering all fields are mandatory!!!",Toast.LENGTH_SHORT).show();
                }

                else {
                    MissingRVModal missingRVModal = new MissingRVModal(name2, city2, state2, pincode2, perdes2, image2);

                /*HashMap<String, String> personMap = new HashMap<>();

                personMap.put("name", name2);
                personMap.put("city", city2);
                personMap.put("state", state2);
                personMap.put("description",perdes2);
                personMap.put("image link", image2);
                personMap.put("pinncode", pincode2);*/

                    databaseReference.child(name2).setValue(missingRVModal);
                    Toast.makeText(addmissingperson.this, "Missing person details added successfully...", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(addmissingperson.this, home.class));
                }

            }
        });



    }
}