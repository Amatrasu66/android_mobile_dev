# Practical 13: Creating an Application to Send an E-mail

## 1. Aim
To develop a native Android application in Java to send email using a prefilled implicit intent (`Intent.ACTION_SENDTO` with `mailto:`) wrapped inside a system chooser dialog, ensuring clean separation of concerns and user control.

## 2. Requirements
- Language: Java (JDK 21 LTS)
- Compile SDK: API 36 | Min SDK: API 24
- Architecture: Single Activity, light theme (`#FFFFFF` background, dark text)
- Components: `EditText` (Recipient, Subject, Body), `Button`, `Intent.ACTION_SENDTO`, `Intent.createChooser`

## 3. Implementation Details
- `MainActivity.java`: Validates recipient syntax (`Patterns.EMAIL_ADDRESS`), subject, and body. Constructs `Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"))` with `EXTRA_EMAIL`, `EXTRA_SUBJECT`, and `EXTRA_TEXT`, launched via `Intent.createChooser()`.
- `activity_main.xml`: Clean light-theme vertical form.
