package com.example.sullo.golfapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //firebase authorization object
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser mUser;
    private static final String TAG = "MainActivity";

    /*Fields for app interface start*/
    private EditText LoginEmail;
    private EditText LoginPassword;
    private Button loginButton;
    private Button CreateUserBtn;
/*Fields for app interface end*/



    /**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




/* instantiate*/
        LoginEmail = (EditText) findViewById(R.id.LoginEmail);
        LoginPassword = (EditText) findViewById(R.id.LoginPassword);
        loginButton = (Button) findViewById(R.id.loginButton);
        CreateUserBtn = (Button) findViewById(R.id.CreateUser);
/* instantiate end*/

//button to load CreateAccount page
        CreateUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreateAccount.class));
                finish();
            }
        });
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
//Creates a new database for users called message
        databaseReference = database.getReference("message");

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//get user and check to see if user is logged in
                mUser = firebaseAuth.getCurrentUser();

                if(mUser != null){
//user signed in
                    Toast.makeText(MainActivity.this, "Signedddddd in", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this, MainScreen.class));
                }
                else{
//user is signed out
                    Toast.makeText(MainActivity.this, "Logged out", Toast.LENGTH_LONG).show();

                }
            }
        };
//event listener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//email and password not empty
                if(!TextUtils.isEmpty(LoginEmail.getText().toString())&&
                        !TextUtils.isEmpty(LoginPassword.getText().toString())) {
                    String email = LoginEmail.getText().toString();
                    String pwd = LoginPassword.getText().toString();

                    login(email, pwd);
                }
                else {
                }
            }
        });
    }






    //login method
    private void login(String email, String pwd) {
        mAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
//Where Logged in.. passed main activity as we are inside the object
                    Toast.makeText(MainActivity.this, "Signed innnn", Toast.LENGTH_LONG).show();
//login to main menu page
                    Intent startMainMenu = new Intent(MainActivity.this, MainScreen.class);
                    startActivity(startMainMenu);
                }
                else {
                    Toast.makeText(MainActivity.this, "PLease try again", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //how to logout from menu using item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.signout){
            mAuth.signOut();
        }
        return super.onOptionsItemSelected(item);
    }

    //create menu for logout
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//getMenuInflater used to instaniate menu XML files into menu ojects using R.menu
        getMenuInflater().inflate(R.menu.logout_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //when app starts up
    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
//if user is not null remove all event listeners for AuthListeners
    protected void onStop() {
        super.onStop();
        if(mAuthListener != null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}