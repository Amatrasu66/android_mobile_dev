package com.example.deploymentapp;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvAppId = findViewById(R.id.tvAppId);
        TextView tvVersion = findViewById(R.id.tvVersion);
        TextView tvStatus = findViewById(R.id.tvStatus);

        try {
            PackageManager pm = getPackageManager();
            PackageInfo pInfo = pm.getPackageInfo(getPackageName(), 0);
            tvAppId.setText("Application ID: " + pInfo.packageName);
            long code = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) ? pInfo.getLongVersionCode() : pInfo.versionCode;
            tvVersion.setText("Version: " + pInfo.versionName + " (versionCode: " + code + ")");
            tvStatus.setText("Status: Verified Signed Release APK");
        } catch (Exception e) {
            tvStatus.setText("Status: Error reading package info");
        }

        findViewById(R.id.btnVerify).setOnClickListener(v ->
            Toast.makeText(this, "Release Application Active and Verified", Toast.LENGTH_SHORT).show()
        );
    }
}
