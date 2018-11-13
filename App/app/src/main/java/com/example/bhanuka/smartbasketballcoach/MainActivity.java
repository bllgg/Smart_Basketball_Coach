package com.example.bhanuka.smartbasketballcoach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    Button start, feedbacks, analysis, profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(this);

        start = (Button) findViewById(R.id.button_start);
        feedbacks = (Button) findViewById(R.id.button_feedbacks);
        analysis = (Button) findViewById(R.id.button_analysis);
        profile = (Button) findViewById(R.id.button_profile);




        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSession();
            }
        });

        feedbacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenFeedbacks();
            }
        });

        analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenAnalysis();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenRegister();
            }
        });

    }

    public void OpenSession(){
        Intent intent = new Intent(this, Session.class);
        startActivity(intent);
    }

    public void OpenFeedbacks(){
        Intent intent = new Intent(this, Feedback.class);
        startActivity(intent);
    }

    public void OpenAnalysis(){
        Intent intent = new Intent(this, Analysis.class);
        startActivity(intent);
    }

    public void OpenRegister(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}
