package com.example.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.explicitintent.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editMessage = findViewById(R.id.editMessage);
        Button btnLaunch = findViewById(R.id.btnLaunch);

        btnLaunch.setOnClickListener(v -> {
            String message = editMessage.getText().toString().trim();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        });
    }
}
