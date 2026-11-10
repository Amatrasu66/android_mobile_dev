package com.example.menubar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TextView tvMenuFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvMenuFeedback = findViewById(R.id.tvMenuFeedback);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        String message;

        if (id == R.id.menu_home) {
            message = "Selected: Home";
        } else if (id == R.id.menu_settings) {
            message = "Selected: Settings";
        } else if (id == R.id.menu_about) {
            message = "Selected: About";
        } else if (id == R.id.menu_help) {
            message = "Selected: Help";
        } else {
            return super.onOptionsItemSelected(item);
        }

        tvMenuFeedback.setText(message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        return true;
    }
}
