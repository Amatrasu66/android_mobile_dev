package com.example.screenorientation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Practical 05: Portrait and Landscape Screen Orientation
 * Course: SCS391 Mobile Application Development Lab
 *
 * Demonstrates:
 * 1. Detecting runtime screen orientation via Configuration.
 * 2. Automatic selection of layout resources (res/layout vs res/layout-land).
 * 3. Handling runtime configuration changes and rendering metrics.
 */
public class MainActivity extends AppCompatActivity {

    private TextView tvOrientationMessage;
    private TextView tvDimensions;
    private TextView tvModeBadge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Automatically selects res/layout/activity_main.xml or res/layout-land/activity_main.xml
        setContentView(R.layout.activity_main);

        tvOrientationMessage = findViewById(R.id.tvOrientationMessage);
        tvDimensions = findViewById(R.id.tvDimensions);
        tvModeBadge = findViewById(R.id.tvModeBadge);

        updateOrientationDetails();

        findViewById(R.id.btnRefresh).setOnClickListener(v -> {
            updateOrientationDetails();
            Toast.makeText(this, "Orientation refreshed!", Toast.LENGTH_SHORT).show();
        });
    }

    private void updateOrientationDetails() {
        int orientation = getResources().getConfiguration().orientation;

        // Query active screen dimensions and density
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        int density = metrics.densityDpi;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            tvOrientationMessage.setText(R.string.msg_landscape);
            tvModeBadge.setText("LANDSCAPE MODE");
            tvDimensions.setText(String.format("Dimensions: %d x %d px | %d dpi (Aspect Ratio: Wide)", width, height, density));
        } else if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            tvOrientationMessage.setText(R.string.msg_portrait);
            tvModeBadge.setText("PORTRAIT MODE");
            tvDimensions.setText(String.format("Dimensions: %d x %d px | %d dpi (Aspect Ratio: Tall)", width, height, density));
        } else {
            tvOrientationMessage.setText("ORIENTATION UNDEFINED");
            tvDimensions.setText(String.format("Dimensions: %d x %d px", width, height));
        }
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateOrientationDetails();
    }
}
