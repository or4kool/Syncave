package com.megaworx.syncave;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Samuel Oriaku on 8/29/2016.
 */
public class SliderThirdFrag extends Fragment {

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.sliderthird, container, false);

        Button button = (Button) view.findViewById(R.id.contbutt);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (firebaseUser == null) {
                    Intent loginIntent = new Intent(view.getContext(), LoginActivity.class);
                    startActivity(loginIntent);
                }
                else{
                    String name = firebaseUser.getDisplayName();
                    Log.e("USERNAME<<o>>", name);
                }
            }
        });

        return view;
    }
}
