# SCS391 Mobile Application Development Lab — Master Portfolio

**Student / Contributor:** Amatrasu66  
**Course Code:** SCS391 – Mobile App Development Lab  
**Platform:** Android Studio (Arch Linux x86_64)  
**Language:** Java (JDK 21 LTS / Android Studio JBR)  
**Target Architecture:** Android SDK 36 (VanillaIceCream) / Min SDK 24 (Nougat)  
**Primary Testing Device:** OnePlus CPH2661 (Android 16, API 36, Physical USB Debugging, Serial `2d242b39`)  
**GitHub Repository:** [https://github.com/Amatrasu66/android_mobile_dev.git](https://github.com/Amatrasu66/android_mobile_dev.git)  
**Master Google Document:** [SCS391 – Mobile App Development Practical File](https://docs.google.com/document/d/1pA0UY_HGMcekwgpwh4SVj7VfuM3f5R5iSJUdMKYosSw/edit)

---

## 1. Project Overview

This repository hosts the complete, verified, end-to-end deliverables for the **SCS391 Mobile App Development Lab** practical curriculum. It contains 10 independent Android Studio projects developed strictly in **Java** and **XML layouts** following modern **Material Design** conventions.

All applications are compiled with Gradle, installed via ADB directly onto an authorized physical Android smartphone (OnePlus CPH2661 running Android 16), functionally exercised, and evidenced by genuine hardware screenshots embedded both in this repository and in the linked Master Google Document.

---

## 2. Practical Directory & Completion Status

| # | Directory | Practical Name | Type | Status | Evidence |
|---|---|---|---|---|---|
| **01** | `01_Android_Studio_Setup` | Android Studio, SDK, SDK Tools, AVD & JDK Setup | Theoretical / Architecture | **COMPLETE** | Technical Guide & Arch Specs |
| **02** | `02_Hello_World` | Hello World Java Application | Core Application | **COMPLETE** | `P02_Hello_World.png` |
| **03** | `03_Intent_Demonstration` | Explicit & Implicit Intents (Data passing, Dialer, Web) | Core Application | **COMPLETE** | 4 Hardware Screenshots |
| **04** | `04_Appointment_Form` | Appointment Form (ImageButton, Spinner, Pickers, ListView) | UI Components & Events | **COMPLETE** | 3 Hardware Screenshots |
| **05** | `05_Screen_Orientation` | Portrait and Landscape Orientation Detection & Layouts | Configuration & Layouts | **COMPLETE** | 2 Hardware Screenshots |
| **06** | `06_Menu_Bar` | Options Menu Bar (Home, Settings, About, Help) | Menus & Navigation | **COMPLETE** | 3 Hardware Screenshots |
| **07** | `07_SMS_Application` | Prefilled SMS via `ACTION_SENDTO` (Zero Permissions) | Intents & Communication | **COMPLETE** | 2 Hardware Screenshots |
| **08** | `08_Email_Application` | Prefilled Email via `ACTION_SENDTO` with System Chooser | Intents & Communication | **COMPLETE** | 2 Hardware Screenshots |
| **09** | `09_CRUD_SQLite` | Student Record Management using SQLiteOpenHelper | Native SQLite Database | **COMPLETE** | 4 Hardware Screenshots |
| **10** | `10_Application_Deployment` | Signed Release APK Build, Deployment & Security Hardening | Deployment & Packaging | **COMPLETE** | Signed Release APK & 2 Screenshots |

---

## 3. Physical Hardware Testing Environment

- **Device Model:** OnePlus CPH2661
- **Device Serial:** `2d242b39`
- **Android OS Version:** Android 16 (Release 16)
- **API Level:** SDK 36
- **Screen Resolution:** 1240 x 2772 pixels
- **Screen Density:** 560 dpi
- **Connection Mode:** USB Debugging via Android Debug Bridge (ADB)
- **Zero Emulator Policy:** All builds verified strictly on bare-metal hardware.

---

## 4. Release Deliverables

Pre-built signed release APK packages signed with APK Signature Scheme v2 (RSA 2048-bit, SHA-256 Digest) are preserved directly in the project repositories:
- `10_Application_Deployment/release/app-release.apk`
- `09_CRUD_SQLite/release/app-release.apk`
- `02_Hello_World/release/app-release.apk`

---

## 5. Repository Structure

```
Android Mobile Development/
├── 01_Android_Studio_Setup/
│   ├── Documentation/PRACTICAL_01_GUIDE.md
│   └── README.md
├── 02_Hello_World/
│   ├── app/
│   ├── release/app-release.apk
│   └── README.md
├── 03_Intent_Demonstration/
│   ├── app/
│   └── README.md
├── 04_Appointment_Form/
│   ├── app/
│   └── README.md
├── 05_Screen_Orientation/
│   ├── app/
│   └── README.md
├── 06_Menu_Bar/
│   ├── app/
│   └── README.md
├── 07_SMS_Application/
│   ├── app/
│   └── README.md
├── 08_Email_Application/
│   ├── app/
│   └── README.md
├── 09_CRUD_SQLite/
│   ├── app/
│   ├── release/app-release.apk
│   └── README.md
├── 10_Application_Deployment/
│   ├── app/
│   ├── release/app-release.apk
│   └── README.md
├── Practical_Screenshots/
│   ├── Practical_02/
│   ├── Practical_03/
│   ├── Practical_04/
│   ├── Practical_05/
│   ├── Practical_06/
│   ├── Practical_07/
│   ├── Practical_08/
│   ├── Practical_09/
│   └── Practical_10/
├── Documentation/
│   ├── MASTER_PRACTICAL_FILE.md
│   ├── PROJECT_OVERVIEW.md
│   ├── IMPLEMENTATION_PLAN.md
│   ├── TESTING_REPORT.md
│   └── PRACTICAL_PROGRESS.md
├── .gitignore
└── README.md
```
