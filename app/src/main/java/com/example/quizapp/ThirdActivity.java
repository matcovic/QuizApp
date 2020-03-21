package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    private Button trueButton;
    private Button falseButton;
    private ImageButton nextButton;
    private TextView questionTextView;

    private int currentIndex = 0;
    private int score = 0;
    private  String playerName = null;

    Question[] questionBank = new Question[]{

            new Question(R.string.question_language,false),
            new Question(R.string.question_currency,true),
            new Question(R.string.question_knownFor,false),
            new Question(R.string.question_Bigger,false),
            new Question(R.string.question_export,true),
            new Question(R.string.question_transport,true),
            new Question(R.string.question_meaning,true)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        trueButton = findViewById(R.id.true_Button);
        falseButton = findViewById(R.id.false_Button);
        nextButton = findViewById(R.id.next_Button);
        questionTextView = findViewById(R.id.textView);
        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        if(!bundle.isEmpty()){
            playerName = bundle.getString("name");
            //Log.d("name","NAME: " +playerName);
        }
        questionTextView.setText(R.string.question_language);
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.true_Button:
                checkAnswer(true);
                break;

            case R.id.false_Button:
                checkAnswer(false);
                break;

            case R.id.next_Button:

                currentIndex = currentIndex + 1;
               // Log.d("Index","Index no: " + currentIndex);
                if(currentIndex < 7){
                    questionTextView.setText(questionBank[currentIndex].getAnswerResId());
                }
                // Goes from 3rd to 4th
                else {
                    String result = String.valueOf(score);
                    Intent thirdActivity = new Intent(ThirdActivity.this, FourthActivity.class);
                    thirdActivity.putExtra("Name", playerName);
                    thirdActivity.putExtra("score", result);
                    startActivity(thirdActivity);
                }
                break;
        }
    }
    private void checkAnswer(boolean userPressed){

        boolean answer = questionBank[currentIndex].isAnswerTrue();
        int toastId = 0;

        if(userPressed == answer){
            toastId = R.string.right_answer;
            score++;
        }
        else{
            toastId = R.string.wrong_answer;
        }

        Toast.makeText(ThirdActivity.this, toastId, Toast.LENGTH_SHORT).show();

    }
}