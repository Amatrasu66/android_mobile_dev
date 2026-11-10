# Practical 03: Demonstration of Implicit Intent

## 1. Aim
To develop a native Android application demonstrating an Implicit Intent by delegating actions to external system applications (such as the system phone dialer or web browser) with proper error handling.

## 2. Requirements
- Language: Java (JDK 21 LTS)
- Compile SDK: API 36 | Min SDK: API 24
- Architecture: Single Activity, light theme (`#FFFFFF` background, dark text)
- Components: `Button`, `Intent.ACTION_DIAL`, `Intent.ACTION_VIEW`

## 3. Implementation Details
- `MainActivity.java`: Contains buttons to launch the system dialer (`tel:9876543210`) and web browser (`https://developer.android.com`), handling `ActivityNotFoundException` gracefully.
- `activity_main.xml`: Clean light vertical layout with high contrast.
