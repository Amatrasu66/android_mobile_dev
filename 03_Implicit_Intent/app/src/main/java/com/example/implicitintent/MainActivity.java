package com.example.implicitintent;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDialer = findViewById(R.id.btnDialer);
        Button btnWeb = findViewById(R.id.btnWeb);

        btnDialer.setOnClickListener(v -> {
            try {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876543210"));
                startActivity(dialIntent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(this, "No phone dialer application found", Toast.LENGTH_SHORT).show();
            }
        });

        btnWeb.setOnClickListener(v -> {
            try {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com"));
                startActivity(webIntent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(this, "No web browser application found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
