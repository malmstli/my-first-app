package fi.arcada.codechallenge;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private boolean isInitialLaunch = true;
    private TextView appCountTextView;
    private TextView welcomeTextView;
    private FloatingActionButton settingsButton;

    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "AppCounterPrefs";
    private static final String APP_COUNTER_KEY = "appCounter";
    private static final String SAVED_TEXT_KEY = "savedText";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appCountTextView = findViewById(R.id.appCount);
        welcomeTextView = findViewById(R.id.welcomeView);
        settingsButton = findViewById(R.id.myFloatingActionButton);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        int appCounter = sharedPreferences.getInt(APP_COUNTER_KEY, 0);
        appCounter++;

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(APP_COUNTER_KEY, appCounter);
        editor.apply();

        appCountTextView.setText(String.valueOf(appCounter));

        welcomeTextView.setText("Hej på dig!");

        settingsButton.setOnClickListener(v -> openSettings());
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!isInitialLaunch) {

            String savedText = sharedPreferences.getString(SAVED_TEXT_KEY, null);
            if (savedText != null && !savedText.isEmpty()) {
                welcomeTextView.setText(savedText);
            } else {
                welcomeTextView.setText("Hej igen!");
            }
        } else {
            isInitialLaunch = false;
        }
    }

    private void openSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
