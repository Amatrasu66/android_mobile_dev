package com.example.googlemapslocation;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_LOCATION = 1001;

    private EditText etLocationLabel;
    private EditText etLatitude;
    private EditText etLongitude;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLocationLabel = findViewById(R.id.etLocationLabel);
        etLatitude = findViewById(R.id.etLatitude);
        etLongitude = findViewById(R.id.etLongitude);
        tvStatus = findViewById(R.id.tvStatus);

        Button btnUseCurrentLocation = findViewById(R.id.btnUseCurrentLocation);
        Button btnOpenMap = findViewById(R.id.btnOpenMap);

        btnUseCurrentLocation.setOnClickListener(v -> checkAndRequestLocation());

        btnOpenMap.setOnClickListener(v -> openInGoogleMaps());
    }

    private void checkAndRequestLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            retrieveCurrentLocation();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    PERMISSION_REQUEST_LOCATION);
        }
    }

    private void retrieveCurrentLocation() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (locationManager == null) {
            tvStatus.setText("Location service unavailable");
            return;
        }

        try {
            Location location = null;
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            }
            if (location == null && locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }

            if (location != null) {
                double lat = location.getLatitude();
                double lng = location.getLongitude();
                etLatitude.setText(String.format(Locale.US, "%.4f", lat));
                etLongitude.setText(String.format(Locale.US, "%.4f", lng));
                etLocationLabel.setText("Current Device Location");
                tvStatus.setText(String.format(Locale.US, "Acquired Location: %.4f, %.4f", lat, lng));
                Toast.makeText(this, "Device coordinates acquired", Toast.LENGTH_SHORT).show();
            } else {
                tvStatus.setText("Location not yet acquired. Ensure GPS is enabled.");
                Toast.makeText(this, "Could not acquire current coordinates. Using given location.", Toast.LENGTH_SHORT).show();
            }
        } catch (SecurityException e) {
            tvStatus.setText("Location permission required");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                retrieveCurrentLocation();
            } else {
                tvStatus.setText("Location permission denied by user");
                Toast.makeText(this, "Permission denied. You can still use a given location.", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void openInGoogleMaps() {
        String latStr = etLatitude.getText().toString().trim();
        String lngStr = etLongitude.getText().toString().trim();
        String label = etLocationLabel.getText().toString().trim();

        if (latStr.isEmpty() || lngStr.isEmpty()) {
            Toast.makeText(this, "Please provide valid coordinates", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double lat = Double.parseDouble(latStr);
            double lng = Double.parseDouble(lngStr);

            String uriStr = String.format(Locale.US, "geo:%f,%f?q=%f,%f(%s)", lat, lng, lat, lng, Uri.encode(label));
            Uri gmmIntentUri = Uri.parse(uriStr);

            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");

            try {
                startActivity(mapIntent);
            } catch (ActivityNotFoundException e) {
                // Fallback to web browser Google Maps
                Uri webUri = Uri.parse(String.format(Locale.US, "https://www.google.com/maps/search/?api=1&query=%f,%f", lat, lng));
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);
                startActivity(webIntent);
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid coordinate format", Toast.LENGTH_SHORT).show();
        }
    }
}
