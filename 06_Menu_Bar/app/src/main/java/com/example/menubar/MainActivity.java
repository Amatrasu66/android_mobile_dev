package com.example.menubar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

/**
 * Practical 06: Menu Bar (Options Menu)
 * Course: SCS391 Mobile Application Development Lab
 *
 * Demonstrates:
 * 1. Defining an Android Options Menu in XML (res/menu/menu_main.xml).
 * 2. Inflating the menu resource in onCreateOptionsMenu().
 * 3. Handling item selection in onOptionsItemSelected() with visual feedback.
 */
public class MainActivity extends AppCompatActivity {

    private TextView tvMenuFeedback;
    private MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind MaterialToolbar and register as the Activity's Action Bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvMenuFeedback = findViewById(R.id.tvMenuFeedback);

        // Helper button to trigger overflow menu programmatically or via tap
        findViewById(R.id.btnOpenMenuProgrammatic).setOnClickListener(v -> {
            if (toolbar != null) {
                toolbar.showOverflowMenu();
            } else {
                openOptionsMenu();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items into the action bar / overflow menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_home) {
            String msg = "Home Selected: Navigated to Home Dashboard";
            tvMenuFeedback.setText(msg);
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_settings) {
            String msg = "Settings Selected: Opened System Configuration";
            tvMenuFeedback.setText(msg);
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_about) {
            String msg = "About Selected: SCS391 Mobile App Dev Lab v1.0";
            tvMenuFeedback.setText(msg);
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_help) {
            String msg = "Help & Support Selected: Documentation Active";
            tvMenuFeedback.setText(msg);
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
