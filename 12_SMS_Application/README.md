# Practical 12: Creating an Application to Send SMS

## 1. Aim
To develop a native Android application in Java to send SMS using a prefilled implicit intent (`Intent.ACTION_SENDTO` with `smsto:`) delegating dispatch to the default messaging client without requiring dangerous runtime permissions.

## 2. Requirements
- Language: Java (JDK 21 LTS)
- Compile SDK: API 36 | Min SDK: API 24
- Architecture: Single Activity, light theme (`#FFFFFF` background, dark text)
- Components: `EditText` (Phone, Message), `Button`, `Intent.ACTION_SENDTO`

## 3. Implementation Details
- `MainActivity.java`: Validates recipient phone number and message body, creates `Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phone))` with `sms_body` extra, and launches default messaging client.
