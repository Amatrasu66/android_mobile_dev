# SCS391 Mobile Application Development Lab — Master Implementation Plan

## 1. Executive Summary
This document specifies the architecture, build pipeline, testing protocols, and documentation plan for completing the 10 university-mandated practicals for **SCS391: Mobile Application Development Lab**.

- **Institution / Course:** SCS391 – Mobile App Development Lab
- **Language / Framework:** Pure Java (JDK 21 LTS), Native Android XML Views, Material Components
- **Target OS / API:** Android 16 (VanillaIceCream), API Level 36 (compileSdk 36, targetSdk 36, minSdk 24)
- **Primary Testing Device:** OnePlus CPH2661 (Physical hardware, USB Debugging via ADB)
- **Master Documentation:** Single Google Document (`1pA0UY_HGMcekwgpwh4SVj7VfuM3f5R5iSJUdMKYosSw`)

---

## 2. Authoritative Practicals (Exactly 10)

| ID | Title | Key Components & Requirements |
|---|---|---|
| **01** | Android Studio Setup & Configuration | Theoretical guide: IDE, SDK, SDK Tools, AVD, JDK architecture |
| **02** | Hello World Application | Java `MainActivity`, ConstraintLayout, TextView ("Hello World!"), Material Theme |
| **03** | Intent Demonstration | Explicit Intent (navigate + data passing), Implicit Intent (browser URL / dialer) |
| **04** | Appointment Form Application | `ImageButton`, `Spinner`, `DatePicker`, `TimePicker`, `ListView` with dynamic entries |
| **05** | Screen Orientation Detection | Portrait / Landscape detection, dynamic messaging, configuration change handling |
| **06** | Options Menu Bar | Action bar overflow menu (Home, Settings, About) with Toast feedback |
| **07** | SMS Intent Application | Phone & message inputs, validation, `Intent.ACTION_SENDTO` with `smsto:` URI |
| **08** | Email Intent Application | Recipient, Subject, Body inputs, validation, `Intent.ACTION_SENDTO` with `mailto:` URI |
| **09** | SQLite Student Records (CRUD) | `SQLiteOpenHelper`, Create, Read (ListView), Update, Delete student records |
| **10** | Release Deployment & Signing | Release APK keystore generation, v1/v2 signing, verification, installation |

---

## 3. Toolchain & Environment Specifications

- **OS:** Arch Linux x86_64 (Linux 7.2.14)
- **JDK:** Eclipse Temurin OpenJDK 21.0.6+7 (`/home/amatrasu/.jdks/jdk-21.0.6+7`) & Android Studio JBR 25
- **Android SDK:** `/home/amatrasu/Android/Sdk` (Platforms: android-36, android-37; Build-tools: 36.0.0)
- **Build System:** Gradle 9.1.0 with Android Gradle Plugin 9.0.1
- **Device Bridge:** Android Debug Bridge (ADB) version 1.0.41, authorized device `2d242b39`
- **Google Docs CLI:** `gdocs` via Antigravity plugin shim

---

## 4. Verification & QA Protocol (Per Practical)

For every practical 02 through 10:
1. **Source Generation:** Write clean, documented Java source and Material XML layouts.
2. **Build Verification:** Run `./gradlew assembleDebug` with `JAVA_HOME=/home/amatrasu/.jdks/jdk-21.0.6+7`.
3. **Hardware Deployment:** Stream install onto OnePlus CPH2661 via `adb install -r <apk>`.
4. **Functional Testing:** Launch with `adb shell am start`, test user flows, verify inputs and state changes.
5. **Evidence Capture:** Take hardware screenshots using `adb exec-out screencap -p > Practical_Screenshots/Practical_XX/PXX_*.png`.
6. **Documentation Sync:** Append the completed practical report to the Master Google Doc and local markdown.
7. **Version Control:** Commit with standard Conventional Commit messages (`feat(practical-XX): ...`).
