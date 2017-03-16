package com.megaworx.syncave;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Samuel Oriaku on 9/8/2016.
 */
public class SignupActivity extends AppCompatActivity implements View.OnClickListener, FirebaseAuth.AuthStateListener{

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener fa;
    String userEmail;
    String userPassword;
    EditText email;
    EditText password;
    EditText username;
    ProgressBar progressBar;
    Intent mainScreenIntent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);

        firebaseAuth = FirebaseAuth.getInstance();

//        Log.e("USERS<<o>>", firebaseAuth.getCurrentUser().toString());

//        fa = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user != null){
//                    Log.e("USER DEY<<o>>", "YEH");
//                }else{
//                    Log.e("USER DEY<<o>>", "NAH");
//                }
//
//            }
//        };


//        fa = (FirebaseAuth.AuthStateListener) firebaseAuth;


        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.cpassword);
        username = (EditText) findViewById(R.id.name);

        Button createButton = (Button) findViewById(R.id.cbutton);

        if (createButton != null){
            createButton.setOnClickListener(this);
        }


        progressBar = (ProgressBar) findViewById(R.id.pgBar);

        removeLoader();

    }

    @Override
    protected void onStop() {
        super.onStop();

        if (firebaseAuth !=null){
            firebaseAuth.removeAuthStateListener(this);
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        firebaseAuth.addAuthStateListener(this);
    }

    @Override
    public void onClick(View v) {
        userEmail = email.getText().toString();
        userPassword = password.getText().toString();


        if (userEmail != null && userPassword != null){

           Log.e("USERNAME::" , userEmail);
            Log.e("USERPASS::" ,userPassword);

            switch(v.getId()){
                case R.id.cbutton:
                    sendDetials(userEmail,userPassword);
            }
        }



    }

    public void sendDetials(String name, String pwd){

        showLoader();

        firebaseAuth.createUserWithEmailAndPassword(name, pwd).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                // if successful go to another page.
//                task.isSuccessful();

                if (task.isSuccessful()){
                    Log.e("USERCREATE<<o>>", String.valueOf(task.isSuccessful()));

                    removeLoader();
                    mainScreen();
                }
                else{

                }
            }
        });


    }

    public void showLoader(){
        progressBar.setVisibility(View.VISIBLE);
    }

    public void removeLoader(){
        progressBar.setVisibility(View.GONE);
    }


    public void mainScreen(){
        mainScreenIntent = new Intent(this, MainActivity.class);
        startActivity(mainScreenIntent);
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null){
            Log.e("USER DEY<<o>>", "YEH");
        }else{
            Log.e("USER DEY<<o>>", "NAH");
        }
    }
}
