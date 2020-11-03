package com.example.restaurantordering;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.restaurantordering.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {
    EditText phoneNumber, name, password;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        phoneNumber = (EditText)findViewById(R.id.PhoneNumber);
        password = (EditText)findViewById(R.id.Password);
        name = (EditText)findViewById(R.id.Name);
        btnSignUp = (Button)findViewById(R.id.SignUp);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(phoneNumber.getText().toString()).exists()){
                            Toast.makeText(SignUp.this, "Phone number already used", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            User user = new User(name.getText().toString(), password.getText().toString());
                            table_user.child(phoneNumber.getText().toString()).setValue(user);
                            Toast.makeText(SignUp.this, "Signed up successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }
        });
    }
}
