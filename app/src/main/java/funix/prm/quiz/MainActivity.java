package funix.prm.quiz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView activity_main_tv_name, activity_main_tv_timer;
    private Button activity_main_btn_submit;
    private EditText activity_main_et_q2_ans, activity_main_et_q4_ans, activity_main_et_q6_ans, activity_main_et_q8_ans, activity_main_et_q10_ans;
    private CheckBox activity_main_cb_q3_op1, activity_main_cb_q3_op2, activity_main_cb_q3_op3, activity_main_cb_q3_op4, activity_main_cb_q7_op1,
                    activity_main_cb_q7_op2, activity_main_cb_q7_op3, activity_main_cb_q7_op4;
    private RadioGroup activity_main_rg_q1, activity_main_rg_q5, activity_main_rg_q9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity_main_rg_q1 = findViewById(R.id.activity_main_rg_q1);
        activity_main_et_q2_ans = findViewById(R.id.activity_main_et_q2_ans);
        activity_main_cb_q3_op1 = findViewById(R.id.activity_main_cb_q3_op1);
        activity_main_cb_q3_op2 = findViewById(R.id.activity_main_cb_q3_op2);
        activity_main_cb_q3_op3 = findViewById(R.id.activity_main_cb_q3_op3);
        activity_main_cb_q3_op4 = findViewById(R.id.activity_main_cb_q3_op4);
        activity_main_et_q4_ans = findViewById(R.id.activity_main_et_q4_ans);
        activity_main_rg_q5 = findViewById(R.id.activity_main_rg_q5);
        activity_main_et_q6_ans = findViewById(R.id.activity_main_et_q6_ans);
        activity_main_cb_q7_op1 = findViewById(R.id.activity_main_cb_q7_op1);
        activity_main_cb_q7_op2 = findViewById(R.id.activity_main_cb_q7_op2);
        activity_main_cb_q7_op3 = findViewById(R.id.activity_main_cb_q7_op3);
        activity_main_cb_q7_op4 = findViewById(R.id.activity_main_cb_q7_op4);
        activity_main_et_q8_ans = findViewById(R.id.activity_main_et_q8_ans);
        activity_main_rg_q9 = findViewById(R.id.activity_main_rg_q9);
        activity_main_et_q10_ans = findViewById(R.id.activity_main_et_q10_ans);

        //name display
        activity_main_tv_name = findViewById(R.id.activity_main_tv_name);
        String name = getIntent().getStringExtra("funix.prm.quiz.NAME");
        if (!name.trim().equals(""))
            activity_main_tv_name.setText(getString(R.string.hello, name));

        //timer
        activity_main_tv_timer = findViewById(R.id.activity_main_tv_timer);
        CountDownTimer ctimer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                activity_main_tv_timer.setText("seconds remaining: " + millisUntilFinished / 1000);
            }
            public void onFinish() {
                activity_main_tv_timer.setText("done!");
                report();
            }
        }.start();

        activity_main_btn_submit = findViewById(R.id.activity_main_btn_submit);
        activity_main_btn_submit.setOnClickListener(view -> {
            report();
        });
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
        RadioButton q1_checkedbutton = findViewById(activity_main_rg_q1.getCheckedRadioButtonId());
        if (q1_checkedbutton != null && q1_checkedbutton.getText().equals("DNA")) {
            countCorrect++;
        }

        //Question 2
        String q2_input = activity_main_et_q2_ans.getText().toString().trim().toLowerCase();
        if (q2_input.equals("vulcanizing")) {
            countCorrect++;
        }

        //Question 3
        if (activity_main_cb_q3_op1.isChecked() && !activity_main_cb_q3_op2.isChecked() && activity_main_cb_q3_op3.isChecked() && !activity_main_cb_q3_op4.isChecked()) {
            countCorrect++;
        }

        //Question 4

        String q4_input = activity_main_et_q4_ans.getText().toString().trim().toLowerCase();
        if (q4_input.equals("gravity")) {
            countCorrect++;
        }

        //Question 5
        RadioButton q5_checkedbutton = findViewById(activity_main_rg_q5.getCheckedRadioButtonId());
        if (q5_checkedbutton != null && q5_checkedbutton.getText().equals("Pine trees")) {
            countCorrect++;
        }

        //Question 6
        String q6_input = activity_main_et_q6_ans.getText().toString().trim().toLowerCase();
        if (q6_input.equals("cloud") || q6_input.equals("clouds")) {
            countCorrect++;
        }

        //Question 7
        if (!activity_main_cb_q7_op1.isChecked() && !activity_main_cb_q7_op2.isChecked() && activity_main_cb_q7_op3.isChecked() && activity_main_cb_q7_op4.isChecked()) {
            countCorrect++;
        }

        //Question 8
        if (activity_main_et_q8_ans.getText().toString().trim().toLowerCase().equals("wrist")) {
            countCorrect++;
        }

        //Question 9
        RadioButton q9_checkedbutton = findViewById(activity_main_rg_q9.getCheckedRadioButtonId());
        if (q9_checkedbutton != null && q9_checkedbutton.getText().equals("Stalagmites")) {
            countCorrect++;
        }

        //Question 10
        String q10_input = activity_main_et_q10_ans.getText().toString().trim().toLowerCase();
        if (q10_input.equals("smelting")) {
            countCorrect++;
        }

        return countCorrect;
    }
}







