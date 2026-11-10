# Practical 04: Demonstration of Explicit Intent

## 1. Aim
To develop a native Android application demonstrating an Explicit Intent by starting a secondary Activity (`SecondActivity`), passing a text payload via Intent extras, and rendering the received data on screen.

## 2. Requirements
- Language: Java (JDK 21 LTS)
- Compile SDK: API 36 | Min SDK: API 24
- Architecture: Dual Activity (`MainActivity`, `SecondActivity`), light theme (`#FFFFFF` background, dark text)
- Components: `EditText`, `Button`, `TextView`, `Intent(Context, Class)`

## 3. Implementation Details
- `MainActivity.java`: Captures user message and launches `SecondActivity` using `Intent(MainActivity.this, SecondActivity.class)` with `putExtra()`.
- `SecondActivity.java`: Retrieves string extra via `getIntent().getStringExtra()` and displays it in a clean `TextView`.
- Registered `SecondActivity` cleanly in `AndroidManifest.xml`.
