package com.example.android.europequiz;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.id;
import static com.example.android.europequiz.R.style.answer;

public class MainActivity extends AppCompatActivity {

    public int points = 0;
    public boolean again = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        Button submitButton = (Button) findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    calculatePoints();
                    displayResult();
                    resetQuiz();
            }
        });
    }

    private void calculatePoints() {
        checkQuestionOne();
        checkQuestionTwo();
        checkQuestionThree();
        checkQuestionFour();
        checkQuestionFIve();
        checkQuestionSix();
    }

    private void checkQuestionOne(){
        boolean correctA = true;
        boolean correctB = true;
        boolean correctC = true;
        boolean correctD = false;

        boolean[] correctAnswersOne= {correctA,correctB,correctC,correctD};

        CheckBox box1A = (CheckBox) findViewById(R.id.checkbox1a);
        CheckBox box1B = (CheckBox) findViewById(R.id.checkbox1b);
        CheckBox box1C = (CheckBox) findViewById(R.id.checkbox1c);
        CheckBox box1D = (CheckBox) findViewById(R.id.checkbox1d);

        boolean answerA =box1A.isChecked();
        boolean answerB =box1B.isChecked();
        boolean answerC =box1C.isChecked();
        boolean answerD =box1D.isChecked();

        boolean[] answersOne = {answerA, answerB, answerC, answerD};

        checkCheckBoxQuestion(correctAnswersOne, answersOne);

    }

    private void checkQuestionTwo(){
        RadioButton correctButton = (RadioButton) findViewById(R.id.radio2c);
        int correctAnswer = correctButton.getId();

        checkRadioButtonQuestion(correctAnswer,answer);
    }

    private void checkQuestionThree() {
        boolean correctA = true;
        boolean correctB = false;
        boolean correctC = false;
        boolean correctD = true;

        boolean[] correctAnswersOne= {correctA,correctB,correctC,correctD};

        CheckBox box3A = (CheckBox) findViewById(R.id.checkbox3a);
        CheckBox box3B = (CheckBox) findViewById(R.id.checkbox3b);
        CheckBox box3C = (CheckBox) findViewById(R.id.checkbox3c);
        CheckBox box3D = (CheckBox) findViewById(R.id.checkbox3d);

        boolean answerA =box3A.isChecked();
        boolean answerB =box3B.isChecked();
        boolean answerC =box3C.isChecked();
        boolean answerD =box3D.isChecked();

        boolean[] answersOne = {answerA, answerB, answerC, answerD};

        checkCheckBoxQuestion(correctAnswersOne, answersOne);
    }

    private void checkQuestionFour() {
        RadioButton correctButton = (RadioButton) findViewById(R.id.radio4a);
        int correctAnswer = correctButton.getId();

        checkRadioButtonQuestion(correctAnswer,answer);
    }

    private void checkQuestionFIve() {
        boolean correctA = true;
        boolean correctB = false;
        boolean correctC = true;
        boolean correctD = true;

        boolean[] correctAnswersOne= {correctA,correctB,correctC,correctD};

        CheckBox box5A = (CheckBox) findViewById(R.id.checkbox5a);
        CheckBox box5B = (CheckBox) findViewById(R.id.checkbox5b);
        CheckBox box5C = (CheckBox) findViewById(R.id.checkbox5c);
        CheckBox box5D = (CheckBox) findViewById(R.id.checkbox5d);

        boolean answerA =box5A.isChecked();
        boolean answerB =box5B.isChecked();
        boolean answerC =box5C.isChecked();
        boolean answerD =box5D.isChecked();

        boolean[] answersOne = {answerA, answerB, answerC, answerD};

        checkCheckBoxQuestion(correctAnswersOne, answersOne);
    }

    private void checkQuestionSix() {
        String correctAnswer6 = getText(R.string.answer6).toString();

        EditText answerText = (EditText) findViewById(R.id.edit6);
        String answer6 = answerText.getText().toString();

        checkEditTextQuestion(correctAnswer6, answer6);
    }

    private void checkCheckBoxQuestion(boolean[] correctAnswers, boolean[] answers) {
        for (int i=0; i < correctAnswers.length; i++) {
            if (correctAnswers[i] == answers[i]) {
                points++;
            } else {
                points--;
            }
        }
    }

    private void checkRadioButtonQuestion(int correctAnswer, int answer) {
        if (correctAnswer == answer) {
            points++;
        }
    }

    private void checkEditTextQuestion(String correctAnswer, String answer) {
        if (correctAnswer.toLowerCase().equals(answer.toLowerCase())){
            points++;
        }
    }

    private void displayResult() {
        Toast.makeText(this, getString(R.string.result) + " " + points + " " + getString(R.string.points), Toast.LENGTH_SHORT).show();

        if (points == 13) {
            Toast.makeText(this, R.string.perfect, Toast.LENGTH_SHORT).show();
        } else if (points > 4 && points < 9){
            Toast.makeText(this, R.string.okay, Toast.LENGTH_SHORT).show();
        } else if (points >= 9 && points < 13)  {
            Toast.makeText(this, R.string.good, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.bad, Toast.LENGTH_SHORT).show();
        }
    }

    private void tryAgain() {
        Button tryAgain = (Button) findViewById(R.id.submit);
        tryAgain.setText(getText(R.string.tryagain).toString());
    }

    private void resetQuiz() {

        CheckBox box1A = (CheckBox) findViewById(R.id.checkbox1a);
        box1A.setChecked(false);
        CheckBox box1B = (CheckBox) findViewById(R.id.checkbox1b);
        box1B.setChecked(false);
        CheckBox box1C = (CheckBox) findViewById(R.id.checkbox1c);
        box1C.setChecked(false);
        CheckBox box1D = (CheckBox) findViewById(R.id.checkbox1d);
        box1D.setChecked(false);

        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radiogroup2);
        radioGroup2.clearCheck();

        CheckBox box3A = (CheckBox) findViewById(R.id.checkbox3a);
        box3A.setChecked(false);
        CheckBox box3B = (CheckBox) findViewById(R.id.checkbox3b);
        box3B.setChecked(false);
        CheckBox box3C = (CheckBox) findViewById(R.id.checkbox3c);
        box3C.setChecked(false);
        CheckBox box3D = (CheckBox) findViewById(R.id.checkbox3d);
        box3D.setChecked(false);

        RadioGroup radioGroup4 = (RadioGroup) findViewById(R.id.radiogroup4);
        radioGroup4.clearCheck();

        CheckBox box5A = (CheckBox) findViewById(R.id.checkbox5a);
        box5A.setChecked(false);
        CheckBox box5B = (CheckBox) findViewById(R.id.checkbox5b);
        box5B.setChecked(false);
        CheckBox box5C = (CheckBox) findViewById(R.id.checkbox5c);
        box5C.setChecked(false);
        CheckBox box5D = (CheckBox) findViewById(R.id.checkbox5d);
        box5D.setChecked(false);

        EditText answerText = (EditText) findViewById(R.id.edit6);
        answerText.setText("");

        Button submit = (Button) findViewById(R.id.submit);
        submit.setText(getText(R.string.submit).toString());

        points = 0;

    }
}
