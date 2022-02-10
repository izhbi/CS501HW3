package edu.bu.ivani.w3_p4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private static final Random random = new Random();
    private static final int TOTAL_QUESTIONS = 10;

    private TextView op1TextView, op2TextView, operationTextView, resultTextView;
    private EditText answerEditText;
    private Button submitBtn, genBtn;

    private int questionsAnswered = 0;
    private int answeredCorrectly = 0;
    private boolean helloSaid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        if (savedInstanceState != null)
            helloSaid = savedInstanceState.getBoolean("helloSaid");

        if (!helloSaid) {
            Toast.makeText(getApplicationContext(), "Welcome " + getIntent().getExtras().getString("login"), Toast.LENGTH_SHORT).show();
            helloSaid = true;
        }

        op1TextView = (TextView) findViewById(R.id.op1TextView);
        op2TextView = (TextView) findViewById(R.id.op2TextView);
        operationTextView = (TextView) findViewById(R.id.operationTextView);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        answerEditText = (EditText) findViewById(R.id.answerEditText);
        submitBtn = (Button) findViewById(R.id.submitBtn);
        genBtn = (Button) findViewById(R.id.genBtn);

        submitBtn.setEnabled(false);
        answerEditText.setEnabled(false);

        genBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                genBtn.setEnabled(false);
                questionsAnswered = 0;
                answeredCorrectly = 0;
                resultTextView.setText("");
                submitBtn.setEnabled(true);
                answerEditText.setEnabled(true);
                generateProblem();
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int op1 = Integer.parseInt(op1TextView.getText().toString());
                    int op2 = Integer.parseInt(op2TextView.getText().toString());
                    if (operationTextView.getText().toString().charAt(0) == '-')
                        op2 = -op2;
                    int answer = Integer.parseInt(answerEditText.getText().toString());
                    if (answer == (op1 + op2))
                        answeredCorrectly++;
                    questionsAnswered++;

                    answerEditText.setText("");

                    if (questionsAnswered < TOTAL_QUESTIONS) {
                        generateProblem();
                    } else {
                        resultTextView.setText(answeredCorrectly + "/" + TOTAL_QUESTIONS + " answered correctly");
                        submitBtn.setEnabled(false);
                        genBtn.setEnabled(true);
                        answerEditText.setEnabled(false);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Please enter numeric resut", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void generateProblem() {
        op1TextView.setText(String.valueOf(random.nextInt(100)));
        op2TextView.setText(String.valueOf(random.nextInt(20)));
        operationTextView.setText(random.nextBoolean() ? "+" : "-");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        op1TextView.setText(savedInstanceState.getString("op1Text"));
        op2TextView.setText(savedInstanceState.getString("op2Text"));
        operationTextView.setText(savedInstanceState.getString("operationText"));
        answerEditText.setText(savedInstanceState.getString("answerText"));
        submitBtn.setEnabled(savedInstanceState.getBoolean("submitBtnEnabled"));
        genBtn.setEnabled(savedInstanceState.getBoolean("genBtnEnabled"));
        answerEditText.setEnabled(savedInstanceState.getBoolean("answerEditTextEnabled"));
        resultTextView.setText(savedInstanceState.getString("resultText"));

        questionsAnswered = savedInstanceState.getInt("questionsAnswered");
        answeredCorrectly = savedInstanceState.getInt("answeredCorrectly");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("op1Text", op1TextView.getText().toString());
        outState.putString("op2Text", op2TextView.getText().toString());
        outState.putString("operationText", operationTextView.getText().toString());
        outState.putString("answerText", answerEditText.getText().toString());
        outState.putBoolean("submitBtnEnabled", submitBtn.isEnabled());
        outState.putBoolean("genBtnEnabled", genBtn.isEnabled());
        outState.putBoolean("answerEditTextEnabled", answerEditText.isEnabled());
        outState.putString("resultText", resultTextView.getText().toString());

        outState.putInt("questionsAnswered", questionsAnswered);
        outState.putInt("answeredCorrectly", answeredCorrectly);
        outState.putBoolean("helloSaid", helloSaid);
    }
}