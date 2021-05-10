package funix.prm.quiz;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView nameTextview, timerTextview;
    private Button submitButton;
    private EditText q2ansEditText, q4ansEditText, q6ansEditText, q8ansEditText, q10ansEditText;
    private CheckBox q3op1CheckBox, q3op2CheckBox, q3op3CheckBox, q3op4CheckBox, q7op1CheckBox,
                    q7op2CheckBox, q7op3CheckBox, q7op4CheckBox;
    private RadioGroup q1RadioGroup, q5RadioGroup, q9RadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q1RadioGroup = findViewById(R.id.activity_main_rg_q1);
        q2ansEditText = findViewById(R.id.activity_main_et_q2_ans);
        q3op1CheckBox = findViewById(R.id.activity_main_cb_q3_op1);
        q3op2CheckBox = findViewById(R.id.activity_main_cb_q3_op2);
        q3op3CheckBox = findViewById(R.id.activity_main_cb_q3_op3);
        q3op4CheckBox = findViewById(R.id.activity_main_cb_q3_op4);
        q4ansEditText = findViewById(R.id.activity_main_et_q4_ans);
        q5RadioGroup = findViewById(R.id.activity_main_rg_q5);
        q6ansEditText = findViewById(R.id.activity_main_et_q6_ans);
        q7op1CheckBox = findViewById(R.id.activity_main_cb_q7_op1);
        q7op2CheckBox = findViewById(R.id.activity_main_cb_q7_op2);
        q7op3CheckBox = findViewById(R.id.activity_main_cb_q7_op3);
        q7op4CheckBox = findViewById(R.id.activity_main_cb_q7_op4);
        q8ansEditText = findViewById(R.id.activity_main_et_q8_ans);
        q9RadioGroup = findViewById(R.id.activity_main_rg_q9);
        q10ansEditText = findViewById(R.id.activity_main_et_q10_ans);

        //name display
        nameTextview = findViewById(R.id.activity_main_tv_name);
        String name = getIntent().getStringExtra("funix.prm.quiz.NAME");
        if (!name.trim().equals(""))
            nameTextview.setText(getString(R.string.hello, name));

        //timer
        timerTextview = findViewById(R.id.activity_main_tv_timer);
        CountDownTimer ctimer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                timerTextview.setText("seconds remaining: " + millisUntilFinished / 1000);
            }
            public void onFinish() {
                timerTextview.setText("done!");
                report();
            }
        }.start();

        submitButton = findViewById(R.id.activity_main_btn_submit);
        submitButton.setOnClickListener(view -> report());
    }

    /**
     * Report result on Toast after evaluate all answers
     */
    public void report() {
            int countCorrect = evaluateAnswer();
            if (countCorrect == 10) {
               Toast.makeText(getApplicationContext(), "Perfect! You scored 10 out of 10!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Try again! You scored " + countCorrect + " out of 10!", Toast.LENGTH_SHORT).show();
           }

    }

    /**Evaluate all answers, return number of correct answers
    */
    public int evaluateAnswer() {
        int countCorrect = 0;

        //Question 1
        RadioButton q1checkedbutton = findViewById(q1RadioGroup.getCheckedRadioButtonId());
        if (q1checkedbutton != null && q1checkedbutton.getText().equals("DNA")) {
            countCorrect++;
        }

        //Question 2
        String q2input = q2ansEditText.getText().toString().trim().toLowerCase();
        if (q2input.equals("vulcanizing")) {
            countCorrect++;
        }

        //Question 3
        if (q3op1CheckBox.isChecked() && !q3op2CheckBox.isChecked() && q3op3CheckBox.isChecked() && !q3op4CheckBox.isChecked()) {
            countCorrect++;
        }

        //Question 4

        String q4input = q4ansEditText.getText().toString().trim().toLowerCase();
        if (q4input.equals("gravity")) {
            countCorrect++;
        }

        //Question 5
        RadioButton q5checkedbutton = findViewById(q5RadioGroup.getCheckedRadioButtonId());
        if (q5checkedbutton != null && q5checkedbutton.getText().equals("Pine trees")) {
            countCorrect++;
        }

        //Question 6
        String q6input = q6ansEditText.getText().toString().trim().toLowerCase();
        if (q6input.equals("cloud") || q6input.equals("clouds")) {
            countCorrect++;
        }

        //Question 7
        if (!q7op1CheckBox.isChecked() && !q7op2CheckBox.isChecked() && q7op3CheckBox.isChecked() && q7op4CheckBox.isChecked()) {
            countCorrect++;
        }

        //Question 8
        if (q8ansEditText.getText().toString().trim().toLowerCase().equals("wrist")) {
            countCorrect++;
        }

        //Question 9
        RadioButton q9checkedbutton = findViewById(q9RadioGroup.getCheckedRadioButtonId());
        if (q9checkedbutton != null && q9checkedbutton.getText().equals("Stalagmites")) {
            countCorrect++;
        }

        //Question 10
        String q10input = q10ansEditText.getText().toString().trim().toLowerCase();
        if (q10input.equals("smelting")) {
            countCorrect++;
        }

        return countCorrect;
    }
}







