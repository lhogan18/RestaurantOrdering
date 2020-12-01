package com.example.restaurantordering;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.restaurantordering.CurrentUser.Current;
import com.example.restaurantordering.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn, btnSignUp, btnGuest;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference table_user = database.getReference("User");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = (Button)findViewById(R.id.SignInButton);
        btnSignUp = (Button)findViewById(R.id.SUButton);
        btnGuest = (Button)findViewById(R.id.guestButton);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent signIn = new Intent(MainActivity.this, SignIn.class);
                startActivity(signIn);
            }

        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent signUp = new Intent(MainActivity.this, SignUp.class);
                startActivity(signUp);
            }
        });
        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent guest = new Intent(MainActivity.this, Home.class);
                User user = new User("Guest", "password");
                Current.currentUser = user;
                startActivity(guest);
                finish();
            }
        });


    }
}