package funix.prm.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class LogInActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "funix.prm.quiz.NAME";
    private TextInputEditText loginTextInputEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginTextInputEditText = findViewById(R.id.activity_login_et_name);
        loginButton = findViewById(R.id.activity_login_btn_login);
        loginButton.setOnClickListener(view -> switchActivitiesWithName());
    }

    /**Switch to MainActivity with login Name
     */
    private void switchActivitiesWithName() {
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
        String name = loginTextInputEditText.getText().toString();
        switchActivityIntent.putExtra(EXTRA_MESSAGE, name);
        startActivity(switchActivityIntent);
    }

}
