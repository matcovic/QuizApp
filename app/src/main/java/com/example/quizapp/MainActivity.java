package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startGameButton;
    ImageView img1, img2, img3, img4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1= (ImageView)findViewById(R.id.imgOne);
        img2= (ImageView)findViewById(R.id.imgTwo);
        img3= (ImageView)findViewById(R.id.imgThree);
        img4= (ImageView)findViewById(R.id.imgFour);
        startGameButton = findViewById(R.id.startGame);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        startGameButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.imgOne:
                img1.setVisibility(View.GONE);
                img2.setVisibility(View.VISIBLE);
                break;
            case R.id.imgTwo:
                img2.setVisibility(View.GONE);
                img3.setVisibility(View.VISIBLE);
                break;
            case R.id.imgThree:
                img3.setVisibility(View.GONE);
                img4.setVisibility(View.VISIBLE);
                break;
            case R.id.imgFour:
                img4.setVisibility(View.GONE);
                img1.setVisibility(View.VISIBLE);
                break;
            case R.id.startGame:
                // Goes from 1st to 2nd
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                break;
        }
    }
}
