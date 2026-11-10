# Practical 06: Developing an Application Using Picker View

## 1. Aim
To develop a native Android application demonstrating DatePicker and TimePicker widgets, capturing user-selected calendar dates and times, and displaying the formatted selection output.

## 2. Requirements
- Language: Java (JDK 21 LTS)
- Compile SDK: API 36 | Min SDK: API 24
- Architecture: Single Activity, light theme (`#FFFFFF` background, dark text)
- Components: `DatePicker`, `TimePicker`, `Button`, `TextView`

## 3. Implementation Details
- `MainActivity.java`: Reads `dayOfMonth`, `month + 1`, and `year` from `DatePicker`, and `hour` and `minute` from `TimePicker`. Formats the result and updates `txtResult`.
- `activity_main.xml`: Clean vertical `ScrollView` layout with spinner-mode pickers and high contrast.
