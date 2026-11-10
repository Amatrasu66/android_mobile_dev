# Practical 10: Storing Local Data Using User Preferences

## 1. Aim
To develop a native Android application demonstrating lightweight key-value data persistence using `SharedPreferences`, saving user data to persistent device storage and loading it across application lifecycle sessions.

## 2. Requirements
- Language: Java (JDK 21 LTS)
- Compile SDK: API 36 | Min SDK: API 24
- Architecture: Single Activity, light theme (`#FFFFFF` background, dark text)
- Components: `SharedPreferences`, `EditText`, `Button`, `TextView`

## 3. Implementation Details
- `MainActivity.java`: Stores a user's name via `preferences.edit().putString().apply()` and reads it via `preferences.getString()`. Automatically checks for and restores saved state upon application launch.
- `activity_main.xml`: Clean vertical light-theme layout.
