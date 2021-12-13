package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button startButton;
    Button option1Button;
    Button option2Button;
    Button option3Button;
    Button option4Button;
    Button playAgainButton;
    TextView scoreTextView;
    TextView timerTextview;
    TextView questionTextView;
    TextView ansTextView;
    GridLayout optionGridLayout;
    int correctOptionTag;
    int numberOfQuestions = 0;
    int score = 0;
    public void start(View view){

        startButton.setVisibility(View.INVISIBLE);
        scoreTextView.setVisibility(View.VISIBLE);
        timerTextview.setVisibility(View.VISIBLE);
        questionTextView.setVisibility(View.VISIBLE);
        option1Button.setVisibility(View.VISIBLE);
        option2Button.setVisibility(View.VISIBLE);
        option3Button.setVisibility(View.VISIBLE);
        option4Button.setVisibility(View.VISIBLE);
        startTimer();
    }
    public void generateQuestion(){
        Random rand = new Random();
        int num1 = rand.nextInt(51);
        int num2 = rand.nextInt(51);
        questionTextView.setText(num1 + " + " + num2);
        int ans = num1 + num2;
        correctOptionTag = rand.nextInt(4);
        int tag1 = Integer.parseInt((String) option1Button.getTag());
        int tag2 = Integer.parseInt((String) option2Button.getTag());
        int tag3 = Integer.parseInt((String) option3Button.getTag());
        int tag4 = Integer.parseInt((String) option4Button.getTag());
        if(tag1==correctOptionTag){
            option1Button.setText(String.valueOf(ans));
        }
        else{
            option1Button.setText(String.valueOf(rand.nextInt(101)));
        }
        if(tag2==correctOptionTag){
            option2Button.setText(String.valueOf(ans));
        }
        else{
            option2Button.setText(String.valueOf(rand.nextInt(101)));
        }
        if(tag3==correctOptionTag){
            option3Button.setText(String.valueOf(ans));
        }
        else{
            option3Button.setText(String.valueOf(rand.nextInt(101)));
        }
        if(tag4==correctOptionTag){
            option4Button.setText(String.valueOf(ans));
        }
        else{
            option4Button.setText(String.valueOf(rand.nextInt(101)));
        }
    }
    public void optionClick(View view){
        Button optionChoosed = (Button) view;
        int optionChoosedTag = Integer.parseInt(optionChoosed.getTag().toString());
        if(correctOptionTag==optionChoosedTag){
            ansTextView.setText("Correct :)");
            ansTextView.setVisibility(View.VISIBLE);
            score++;
            numberOfQuestions++;
        }
        else{
            ansTextView.setText("Wrong :|");
            ansTextView.setVisibility(View.VISIBLE);
            numberOfQuestions++;
        }
        scoreTextView.setText(score + "/" + numberOfQuestions);
        generateQuestion();
    }
    public void playAgain(View view){
        generateQuestion();
        questionTextView.setVisibility(View.VISIBLE);
        timerTextview.setText("30s");
        startTimer();
        playAgainButton.setVisibility(View.INVISIBLE);
        option1Button.setEnabled(true);
        option2Button.setEnabled(true);
        option3Button.setEnabled(true);
        option4Button.setEnabled(true);
        ansTextView.setVisibility(View.INVISIBLE);
        score=numberOfQuestions=0;
        scoreTextView.setText(score + "/" + numberOfQuestions);
    }
    public void startTimer(){
        new CountDownTimer(30000 + 100,1000){
            public void onTick(long millisUntilFinished) {
                int secondLeft = (int) millisUntilFinished/1000;
                timerTextview.setText(secondLeft + "s");

            }

            public void onFinish() {
                ansTextView.setText("DONE!");
                option1Button.setEnabled(false);
                option2Button.setEnabled(false);
                option3Button.setEnabled(false);
                option4Button.setEnabled(false);
                playAgainButton.setVisibility(View.VISIBLE);
                questionTextView.setVisibility(View.INVISIBLE);
            }
        }.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.startButton);
        scoreTextView = findViewById(R.id.scoreTextView);
        timerTextview = findViewById(R.id.timerTextView);
        questionTextView = findViewById(R.id.questionTextView);
        ansTextView = findViewById(R.id.ansTextView);
        option1Button = findViewById(R.id.option1Button);
        option2Button = findViewById(R.id.option2Button);
        option3Button = findViewById(R.id.option3Button);
        option4Button = findViewById(R.id.option4Button);
        playAgainButton = findViewById(R.id.playAgainButton);
        scoreTextView.setVisibility(View.INVISIBLE);
        timerTextview.setVisibility(View.INVISIBLE);
        questionTextView.setVisibility(View.INVISIBLE);
        ansTextView.setVisibility(View.INVISIBLE);
        option1Button.setVisibility(View.INVISIBLE);
        option2Button.setVisibility(View.INVISIBLE);
        option3Button.setVisibility(View.INVISIBLE);
        option4Button.setVisibility(View.INVISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);
        generateQuestion();
    }
}