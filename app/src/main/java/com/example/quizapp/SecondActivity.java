package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText setName;
    private Button nextButton;
    public String playerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setName = (EditText) findViewById(R.id.setName);
        nextButton = findViewById(R.id.secondNext);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Goes from 2nd to 3rd
        Intent secondActivity = new Intent(SecondActivity.this, ThirdActivity.class);
        secondActivity.putExtra("name",setName.getText().toString());
        startActivity(secondActivity);
    }
}
