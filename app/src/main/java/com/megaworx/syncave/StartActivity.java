package com.megaworx.syncave;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {

    private static final long TIME = 2000;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

//        firebaseAuth = FirebaseAuth.getInstance();
//        firebaseUser = firebaseAuth.getCurrentUser();
//
//        if (firebaseuser )

        workDisplay();
    }


    public void workDisplay(){

            new Handler().postDelayed(


                    new Runnable() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(StartActivity.this, Slider.class);
                            startActivity(intent);

                            finish();
                        }
                    }, TIME);

    }


}
