package com.example.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvReceivedMessage = findViewById(R.id.tvReceivedMessage);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(MainActivity.EXTRA_MESSAGE)) {
            String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            tvReceivedMessage.setText(message);
        } else {
            tvReceivedMessage.setText("No data received");
        }
    }
}
