package funix.prm.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class LogInActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "funix.prm.quiz.NAME";
    private TextInputEditText activity_login_et_name;
    private Button activity_login_btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        activity_login_et_name = findViewById(R.id.activity_login_et_name);
        activity_login_btn_login = findViewById(R.id.activity_login_btn_login);
        activity_login_btn_login.setOnClickListener(view -> switchActivitiesWithName());
    }

    /**Switch to MainActivity with login Name
     */
    private void switchActivitiesWithName() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        String name = activity_login_et_name.getText().toString();
        switchActivityIntent.putExtra(EXTRA_MESSAGE, name);
        startActivity(switchActivityIntent);
    }

}
