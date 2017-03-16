package com.megaworx.syncave;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Samuel Oriaku on 9/22/2016.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RelativeLayout locaatePhone;
    RelativeLayout backupPhone;
    RelativeLayout erasePhone;
    RelativeLayout ringPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        locaatePhone = (RelativeLayout) findViewById(R.id.firstarea);
        locaatePhone.setOnClickListener(this);

        backupPhone = (RelativeLayout) findViewById(R.id.secondarea);
        backupPhone.setOnClickListener(this);

        erasePhone = (RelativeLayout) findViewById(R.id.thirdarea);
        erasePhone.setOnClickListener(this);

        ringPhone = (RelativeLayout) findViewById(R.id.fourtharea);
        ringPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.firstarea:
                //open locate phone activity
                break;
            case R.id.secondarea:
                //open activity
                break;
            case R.id.thirdarea:
                //open activity
                break;
            case R.id.fourtharea:
                //open activity
                break;
        }
    }
}
