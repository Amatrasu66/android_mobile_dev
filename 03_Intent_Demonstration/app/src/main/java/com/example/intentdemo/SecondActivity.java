package com.example.intentdemo;

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
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        if (message != null && !message.isEmpty()) {
            tvReceivedMessage.setText(message);
        } else {
            tvReceivedMessage.setText("No message received");
        }

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }
}
