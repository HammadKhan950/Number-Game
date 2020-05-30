package com.example.braintrainerudemy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int numberOfQuestions=0;
    int score=0;
    int locationOfCorrectAnswer;
    TextView textView2;
    Button goButton;
    TextView sumTextView;
    TextView resultTextView;
    TextView timerTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playAgain;
    ConstraintLayout gameLayout;
    ArrayList<Integer> answers=new ArrayList<Integer>();
    public void playAgain(View view){
        score=0;
        numberOfQuestions=0;
        timerTextView.setText("30s");
        textView2.setText(Integer.toString(score)+ "/" +Integer.toString(numberOfQuestions));
        newQuestion();
        playAgain.setVisibility(View.INVISIBLE);
        resultTextView.setText("");
        new CountDownTimer(30000+100,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(millisUntilFinished/1000+"s");
            }

            @Override
            public void onFinish() {

                resultTextView.setText("Done!!");
                playAgain.setVisibility(View.VISIBLE);

            }
        }.start();
    }
    public void start(View view){
        goButton.setVisibility(View.INVISIBLE);
        playAgain(findViewById(R.id.sumTextView));
        gameLayout.setVisibility(View.VISIBLE);
    }
    public void chooseAnswer(View view){
       if(Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())) {
           resultTextView.setText("Correct");
           score++;
       }
           else{
               resultTextView.setText("Wrong");
           }
           newQuestion();

           numberOfQuestions++;
        textView2.setText(score+ "/" +numberOfQuestions);

        }
        public void newQuestion()
        {
            Random random=new Random();
            int a=random.nextInt(21);
            int b=random.nextInt(21);
            sumTextView.setText(a +"+"+b);
            locationOfCorrectAnswer=random.nextInt(4);
            answers.clear();
            for(int i=0;i<4;i++) {
                if (i == locationOfCorrectAnswer) {
                    answers.add(a + b);
                } else {
                    int wrongAnswer=random.nextInt(41);
                    while(wrongAnswer ==a+b){
                        wrongAnswer=random.nextInt(41);
                    }
                    answers.add(wrongAnswer);

                }
            }
            button0.setText(Integer.toString(answers.get(0)));
            button1.setText(Integer.toString(answers.get(1)));
            button2.setText(Integer.toString(answers.get(2)));
            button3.setText(Integer.toString(answers.get(3)));
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Math Quiz");
        gameLayout=(ConstraintLayout)findViewById(R.id.gameLayout);
        playAgain=(Button)findViewById(R.id.playAgainButton);
        textView2=(TextView)findViewById(R.id.textView2);
        goButton=(Button)findViewById(R.id.goButton);
        goButton.setVisibility(View.VISIBLE);
        sumTextView=(TextView)findViewById(R.id.sumTextView);
        button0=(Button)findViewById(R.id.button0) ;
        button1=(Button)findViewById(R.id.button1) ;
        button2=(Button)findViewById(R.id.button2) ;
        button3=(Button)findViewById(R.id.button3) ;
        resultTextView=(TextView)findViewById(R.id.resultTextView);
        timerTextView=(TextView)findViewById(R.id.scoreTextView);
        gameLayout.setVisibility(View.INVISIBLE);


}
}
