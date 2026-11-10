# Practical 14: Displaying a Map Based on Current or Given Location

## 1. Aim
To develop a native Android application that displays a location using Google Maps, allowing the user to view either a given geographical coordinate (e.g. Golden Temple, Amritsar: `31.6200, 74.8765`) or dynamically acquire device coordinates via `LocationManager` and open the location directly in Google Maps.

## 2. Requirements
- Language: Java (JDK 21 LTS)
- Compile SDK: API 36 | Min SDK: API 24
- Architecture: Single Activity, light theme (`#FFFFFF` background, dark text)
- Components: `LocationManager`, `EditText` (Latitude, Longitude, Label), `Button`, `Intent.ACTION_VIEW` (`geo:` URI scheme)

## 3. Implementation Details
- `MainActivity.java`: Allows entering given latitude and longitude coordinates or requesting runtime location permission to acquire current GPS coordinates. Dispatches a clean `geo:` URI intent (`geo:lat,lng?q=lat,lng(label)`) targeting the Google Maps client (`com.google.android.apps.maps`) with graceful web browser fallback.
- `activity_main.xml`: Clean light vertical layout with inputs, action buttons, and status indicator.
