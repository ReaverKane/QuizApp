package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.Objects;

import static com.example.android.quizapp.R.drawable.q1;
import static com.example.android.quizapp.R.drawable.q6;
import static com.example.android.quizapp.R.string.Q8;

public class MainActivity extends AppCompatActivity {

    //Declaring Views prehentively to save resources.
    EditText qOneA;
    CheckBox qTwoA;
    CheckBox qTwoB;
    CheckBox qTwoC;
    CheckBox qTwoD;
    EditText qFourA;
    EditText qFivePerson;
    EditText qFivePlace;
    RadioButton qSixC;
    RadioButton qSevenD;
    CheckBox qEightA;
    CheckBox qEightB;
    CheckBox qEightC;
    CheckBox qEightD;
    CheckBox qNineA;
    CheckBox qNineB;
    CheckBox qNineC;
    CheckBox qNineD;
    RadioButton qTenB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View Search on Create. Thanks Alex_234 for the tip (well not to me, but i take them where i find them ^_^)
        qOneA = (EditText) findViewById(R.id.Q1_A);
        qTwoA = (CheckBox) findViewById(R.id.Q2_A);
        qTwoB = (CheckBox) findViewById(R.id.Q2_B);
        qTwoC = (CheckBox) findViewById(R.id.Q2_C);
        qTwoD = (CheckBox) findViewById(R.id.Q2_D);
        qFourA = (EditText) findViewById(R.id.Q4_A);
        qFivePerson = (EditText) findViewById(R.id.Q5_Person);
        qFivePlace = (EditText) findViewById(R.id.Q5_Place);
        qSixC = (RadioButton) findViewById(R.id.Q_6C);
        qSevenD = (RadioButton) findViewById(R.id.Q_7D);
        qEightA = (CheckBox) findViewById(R.id.Q8_A);
        qEightB = (CheckBox) findViewById(R.id.Q8_B);
        qEightC = (CheckBox) findViewById(R.id.Q8_C);
        qEightD = (CheckBox) findViewById(R.id.Q8_D);
        qNineA = (CheckBox) findViewById(R.id.Q9_A);
        qNineB = (CheckBox) findViewById(R.id.Q9_B);
        qNineC = (CheckBox) findViewById(R.id.Q9_C);
        qNineD = (CheckBox) findViewById(R.id.Q9_D);
        qTenB = (RadioButton) findViewById(R.id.Q_10B);

    }

    //Get Grades When "Grade Me!" is Pressed.
    public void gradeMe(View v) {
        double finalGrade = getGrades();
        if (finalGrade < 5) {
            Toast.makeText(getApplicationContext(),
                    getResources().getString(R.string.fail_grade, finalGrade),
                    Toast.LENGTH_LONG).show();
        } else {
            if (5 <= finalGrade && finalGrade < 8) {
                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.good_grade, finalGrade),
                        Toast.LENGTH_LONG).show();
            } else {
                if (8 <= finalGrade && finalGrade < 10) {
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.great_grade, finalGrade),
                            Toast.LENGTH_LONG).show();
                } else {
                    if (finalGrade == 10) {
                        Toast.makeText(getApplicationContext(),
                                getResources().getString(R.string.perfect_grade, finalGrade),
                                Toast.LENGTH_LONG).show();

                    }
                }
            }
        }
    }


    private double getGrades() {
        //Declare Grade variable, set to 0
        double grade = 0;

        // Get Answer to Question 1
        String q1A = qOneA.getText().toString();

        //Grade it (Right answer = "Elephant")
        if (q1A.equals("Elephant")) {
            grade = grade + 1;
        }

        // Get Answers to Question 2
        boolean isq2A = qTwoA.isChecked();
        boolean isq2B = qTwoB.isChecked();
        boolean isq2C = qTwoC.isChecked();
        boolean isq2D = qTwoD.isChecked();

        //Grade it Right answers are 2A and 2D. (0.5 points each, wrong answers result in a 0.5 point penalty)
        if (isq2A) {
            grade = grade + 0.5;
        }
        if (isq2B) {
            grade = grade - 0.5;
        }
        if (isq2C) {
            grade = grade - 0.5;
        }
        if (isq2D) {
            grade = grade + 0.5;
        }

        //Get Answer to Question 3
        RadioButton qThreeA = (RadioButton) findViewById(R.id.Q_3A);
        boolean isq3A = qThreeA.isChecked();

        //Grade it, Right answer is 3A
        if (isq3A) {
            grade = grade + 1;
        }

        //Get Answer to Question 4
        String q4A = qFourA.getText().toString();
        //TODO Find a way to stop app from crashing when the following code is used and q4 isn't filled.
        //So far using a if statement to skip if qFourA == null and setting the variable to 0 didn't work.
        //splitting the method and doing the same test to the string, or when string == "" didn't work either.
        // q4A = Integer.parseInt(qFourA.getText().toString());

        //Grade it, Right Answer is "5" (because string)
        if (q4A.equals("5")) {
            grade = grade + 1;
        }

        //Get Answer to Question 5
        String q5Person = qFivePerson.getText().toString();
        String q5Place = qFivePlace.getText().toString();

        //Grade it, Right answers are "MacDonald" and "Farm", 0.5 Points each
        if (q5Person.equals("MacDonald")) {
            grade = grade + 0.5;
        }
        if (q5Place.equals("Farm")) {
            grade = grade + 0.5;
        }

        //Get Answer to Question 6
        boolean isq6C = qSixC.isChecked();

        //Grade it, right answer is 6C
        if (isq6C) {
            grade = grade + 1;
        }

        //Get Answer to Question 7
        boolean isq7D = qSevenD.isChecked();

        //Grade It, Right answer is 7D
        if (isq7D) {
            grade = grade + 1;
        }

        //Get Answer to Question 8
        boolean isq8A = qEightA.isChecked();
        boolean isq8B = qEightB.isChecked();
        boolean isq8C = qEightC.isChecked();
        boolean isq8D = qEightD.isChecked();

        //Grade it, Right Answers are 8A and 8C (-0.5 per wrong answer)
        if (isq8A) {
            grade = grade + 0.5;
        }
        if (isq8B) {
            grade = grade - 0.5;
        }
        if (isq8C) {
            grade = grade + 0.5;
        }
        if (isq8D) {
            grade = grade - 0.5;
        }

        //Get Answer to Question 9
        boolean isq9A = qNineA.isChecked();
        boolean isq9B = qNineB.isChecked();
        boolean isq9C = qNineC.isChecked();
        boolean isq9D = qNineD.isChecked();

        //Grade it, right answers are 9B and 9C
        if (isq9A) {
            grade = grade - 0.5;
        }
        if (isq9B) {
            grade = grade + 0.5;
        }
        if (isq9C) {
            grade = grade + 0.5;
        }
        if (isq9D) {
            grade = grade - 0.5;
        }

        //Get Answer to Question 10
        boolean isq10B = qTenB.isChecked();

        //Grade it, right answer is No (B)
        if (isq10B) {
            grade = grade + 1;
        }
        Log.v("MainActivity", "Grade: " + grade);
        return grade;
    }


    public void restartTest(View v) {
        ScrollView mainScrollView = (ScrollView) findViewById(R.id.scrollView);
        mainScrollView.fullScroll(ScrollView.FOCUS_UP);
    }
}
