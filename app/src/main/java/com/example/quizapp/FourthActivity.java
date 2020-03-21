package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView showScore;
    private  TextView showName;
    private Button goToMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        showName = findViewById(R.id.showName);
        showScore = findViewById(R.id.showScore);
        goToMainMenu = findViewById(R.id.goToMainMenu);
        goToMainMenu.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        if(!bundle.isEmpty()){
            String p1 = bundle.getString("Name");
            showName.setText(p1);
            //Log.d("name","NAME: " +p1);
            showScore.setText(bundle.getString("score"));
        }
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(FourthActivity.this, MainActivity.class));
    }
}
