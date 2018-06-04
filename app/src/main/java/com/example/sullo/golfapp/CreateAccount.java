package com.example.sullo.golfapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateAccount extends AppCompatActivity {

    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mDataBase;
    private FirebaseAuth mAuth;
    private ProgressDialog mProgressDialog;
    private EditText firstNameCreateAcc;
    private EditText lastNameCreateAcc;
    private EditText emailCreateAcc;
    private EditText passwordAcc;
    private Button RegisterUserBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mDataBase = FirebaseDatabase.getInstance();
//Creates a new database for users called Users
        mDatabaseReference = mDataBase.getReference().child("Users");
        mAuth = FirebaseAuth.getInstance();

        mProgressDialog = new ProgressDialog(this);

        firstNameCreateAcc = (EditText) findViewById(R.id.firstNameCreateAcc);
        lastNameCreateAcc = (EditText) findViewById(R.id.lastNameCreateAcc);
        emailCreateAcc = (EditText) findViewById(R.id.emailCreateAcc);
        passwordAcc = (EditText) findViewById(R.id.passwordAcc);
        RegisterUserBtn = (Button) findViewById(R.id.RegisterUserBtn);

        RegisterUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewAcccount();
            }
        });
    }
    //get texts from fields and create a new account
    public void createNewAcccount(){
        final String firstName = firstNameCreateAcc.getText().toString().trim();
        final String lastName = lastNameCreateAcc.getText().toString().trim();
        final String email = emailCreateAcc.getText().toString().trim();
        String password = passwordAcc.getText().toString().trim();

        if(!TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(lastName) &&
                !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
//progress message
            mProgressDialog.setMessage("Creating your account");
            mProgressDialog.show();

//createUserWithEmailAndPassword is a firebase method. mAuth lets you access it.
            mAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    if (authResult != null) {
                        String userId = mAuth.getCurrentUser().getUid();
                        DatabaseReference currentUser = mDatabaseReference.child(userId);
                        currentUser.child("First Name").setValue(firstName);
                        currentUser.child("Surname").setValue(lastName);
                        currentUser.child("email").setValue(email);

                        mProgressDialog.dismiss();

//login to mainMenu page
                        Intent startMainMenu = new Intent(CreateAccount.this, MainScreen.class);
                        startMainMenu.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(startMainMenu);
                    }
                }
            });
        }
    }
}
