package com.example.userpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "UserPrefs";
    private static final String KEY_USER_NAME = "user_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editName = findViewById(R.id.editName);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnLoad = findViewById(R.id.btnLoad);
        TextView txtResult = findViewById(R.id.txtResult);

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // Auto-load preference on launch if available
        String initialName = preferences.getString(KEY_USER_NAME, null);
        if (initialName != null && !initialName.isEmpty()) {
            txtResult.setText("Stored Name: " + initialName);
            editName.setText(initialName);
        }

        btnSave.setOnClickListener(v -> {
            String name = editName.getText().toString().trim();
            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter a name to save", Toast.LENGTH_SHORT).show();
                return;
            }
            preferences.edit().putString(KEY_USER_NAME, name).apply();
            txtResult.setText("Saved successfully: " + name);
            Toast.makeText(this, "Preference saved to storage", Toast.LENGTH_SHORT).show();
        });

        btnLoad.setOnClickListener(v -> {
            String savedName = preferences.getString(KEY_USER_NAME, "No data saved");
            txtResult.setText("Loaded: " + savedName);
        });
    }
}
