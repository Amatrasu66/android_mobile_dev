# Practical 15: Android Application Packaging, Cryptographic Signing, and Deployment

## 1. Aim
To configure, compile, sign with APK Signature Scheme v2, verify, and deploy a production release Android APK on a physical Android device.

## 2. Requirements
- Language: Java (JDK 21 LTS)
- Compile SDK: API 36 | Min SDK: API 24
- Architecture: Single Activity, light theme (`#FFFFFF` background, dark text)
- Security Tools: `keytool`, `apksigner`, `zipalign`

## 3. Implementation Details
- `MainActivity.java`: Verifies application ID, version specifications, runtime `FLAG_DEBUGGABLE` status, and signature integrity.
- `app/build.gradle.kts`: Configures custom release `signingConfigs` block.
- Release Deliverable: [15_Application_Deployment/release/app-release.apk](file:///home/amatrasu/Projects/andriod_mobile_development/15_Application_Deployment/release/app-release.apk).
