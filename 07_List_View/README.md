# Practical 07: Developing an Application Using ListView

## 1. Aim
To develop a native Android application demonstrating the `ListView` widget populated with a dataset via `ArrayAdapter`, handling item click events to display interactive user feedback.

## 2. Requirements
- Language: Java (JDK 21 LTS)
- Compile SDK: API 36 | Min SDK: API 24
- Architecture: Single Activity, light theme (`#FFFFFF` background, dark text)
- Components: `ListView`, `ArrayAdapter<String>`, `Toast`

## 3. Implementation Details
- `MainActivity.java`: Binds a string array of programming languages to `ListView` using `android.R.layout.simple_list_item_1`. Dispatches a `Toast` notification on item selection.
- `activity_main.xml`: Clean vertical layout with high contrast.
