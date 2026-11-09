package com.example.screenorientation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvOrientationMessage = findViewById(R.id.tvOrientationMessage);
        TextView tvModeInfo = findViewById(R.id.tvModeInfo);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            tvOrientationMessage.setText("Landscape Mode");
            tvModeInfo.setText("Current Screen Orientation: LANDSCAPE");
        } else {
            tvOrientationMessage.setText("Portrait Mode");
            tvModeInfo.setText("Current Screen Orientation: PORTRAIT");
        }
    }
}
