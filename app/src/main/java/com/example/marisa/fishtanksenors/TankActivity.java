package com.example.marisa.fishtanksenors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TankActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private TextView textViewUserEmail;
    private TextView textViewTankActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tank);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null)
        {
            //user is not logged in
            finish();
            startActivity(new Intent(this, LoginActivity.class));

        }
        //user is logged in
        FirebaseUser user = firebaseAuth.getCurrentUser();

        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        textViewUserEmail.setText("Welcome " + user.getEmail());
        textViewTankActivity = (TextView) findViewById(R.id.textViewBack);

        textViewTankActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if(view == textViewTankActivity)
        {
            finish();
            startActivity(new Intent(this, ProfileActivity.class));
        }
    }
}
