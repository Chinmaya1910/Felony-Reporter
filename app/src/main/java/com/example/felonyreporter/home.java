package com.example.felonyreporter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class home extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private FirebaseAuth mauth;
    private FirebaseDatabase firebaseDatabase;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button btn, btn2;

        DatabaseReference databaseReference;
        mauth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigationView);
        actionBarDrawerToggle= new ActionBarDrawerToggle( this, drawerLayout,R.string.open,R.string.close );
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_home:
                        Log.i("MENU_DRAWER_TAG", "Home item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent i=new Intent(getApplicationContext(),home.class);
                        startActivity(i);
                        break;
                    case R.id.nav_missing_search:
                        Log.i("SEARCH_DRAWER_TAG", "Missing person search item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent i2=new Intent(getApplicationContext(),Missing_search.class);
                        startActivity(i2);
                        break;
                    case R.id.nav_user:
                        Log.i("PROFILE_DRAWER_TAG", "User item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent i3=new Intent(getApplicationContext(),users.class);
                        startActivity(i3);
                        break;
                    case R.id.nav_report:
                        Log.i("REPORT_DRAWER_TAG", "Report item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_logout:
                        Toast.makeText(home.this,"User Logged Out...",Toast.LENGTH_SHORT).show();
                        mauth.signOut();
                        Intent i4 = new Intent(home.this,MainActivity.class);
                        startActivity(i4);

                        break;
                }
                return true;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, addcrime.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this, addmissingperson.class));
            }
        });

    }
}