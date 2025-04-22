package fi.arcada.codechallenge;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private Button resetButton;
    private Button saveButton;
    private EditText inputText;

    private static final String PREFS_NAME = "AppCounterPrefs";
    private static final String APP_COUNTER_KEY = "appCounter";
    private static final String SAVED_TEXT_KEY = "savedText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        inputText = findViewById(R.id.inputText);
        saveButton = findViewById(R.id.saveButton);
        resetButton = findViewById(R.id.resetButton);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        saveButton.setOnClickListener(v -> {
            String text = inputText.getText().toString();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(SAVED_TEXT_KEY, text);
            editor.apply();
            finish();
        });

        resetButton.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(APP_COUNTER_KEY, 0);
            editor.apply();
        });
    }

}
