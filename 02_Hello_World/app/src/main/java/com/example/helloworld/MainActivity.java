package com.example.helloworld;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Practical 02: Hello World Application
 * Course: SCS391 Mobile Application Development Lab
 *
 * This Activity serves as the entry point for the application.
 * It demonstrates initializing an Activity lifecycle, inflating
 * an XML layout, and referencing View widgets (TextView).
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the XML layout into the View hierarchy
        setContentView(R.layout.activity_main);

        // Reference the TextView widget
        TextView tvHelloWorld = findViewById(R.id.tvHelloWorld);
        // Programmatically confirm the text content
        tvHelloWorld.setText(R.string.hello_world);
    }
}
