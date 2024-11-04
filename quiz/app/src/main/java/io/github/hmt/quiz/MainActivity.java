package io.github.hmt.quiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button mBtnTrue;
    private Button mBtnFalse;
    private Button mBtnNext;
    private Button mBtnPrevious;
    private TextView mTextViewQuestion;

    private int mCurrentIndex = 0;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question1, false),
            new Question(R.string.question2, true),
            new Question(R.string.question3, false),
            new Question(R.string.question4, true),
    };

    private void checkAnswer(boolean userPress){
        boolean answer = mQuestionBank[mCurrentIndex].ismAnswer();

        String mess = "";
        if(userPress == answer)
            mess = "Correct!!!";
        else
            mess = "Incorrect!!!";
        Toast.makeText(this, mess, Toast.LENGTH_SHORT).show();
    }

    private void updateQuestion() {
        mTextViewQuestion.setText(mQuestionBank[mCurrentIndex].getTextResId());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewQuestion = findViewById(R.id.textview_question);

        mBtnTrue = findViewById(R.id.button_True);
        mBtnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });

        mBtnFalse = findViewById(R.id.button_False);
        mBtnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        mBtnNext = findViewById(R.id.button_Next);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1)%mQuestionBank.length;
                updateQuestion();
            };
        });

//        protected void onSaveInstanceState(@NonNull Bundle outState)


        updateQuestion();
    }
}