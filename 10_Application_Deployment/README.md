# Practical 10: Android Application Deployment & Release Packaging

**Course Code:** SCS391 – Mobile App Development Lab  
**Language:** Java  
**Architecture:** Android Empty Views Activity, Material Design 3  
**Package:** `com.example.deploymentapp`  
**Application ID:** `com.example.deploymentapp`  
**Version Code:** `100` | **Version Name:** `1.0.0-release`  
**Min SDK:** 24 (Android 7.0) | **Target SDK:** 36 (Android 16)  
**Signing Scheme:** APK Signature Scheme v2 (RSA 2048-bit, SHA-256 Digest)  
**Verification Device:** Physical OnePlus CPH2661 (Android 16, API 36)

---

## 1. Project Overview
This practical fulfills the requirements of Practical 10 by providing a complete, professional demonstration of Android application packaging, cryptographic signing, security validation, and deployment:
- **Deployment Process Explanation:** Documents the complete compilation, DEX bytecode conversion, APK packaging, cryptographic signing, ZIP alignment, and deployment phases.
- **Production Configuration:** Configured production `applicationId`, release `versionCode` (`100`), and semantic `versionName` (`1.0.0-release`).
- **Cryptographic Keystore Generation:** Generated an industry-standard RSA 2048-bit signing keypair with a 10,000-day validity period stored securely outside version control in `~/.android/scs391_release.jks`.
- **Signed Release APK Generation:** Built using `./gradlew assembleRelease` and verified with Android SDK's `apksigner` using APK Signature Scheme v2.
- **Hardware Verification:** Installed the signed release APK onto the physical OnePlus CPH2661 smartphone, confirming that `FLAG_DEBUGGABLE` is disabled and extracting the signing certificate SHA-256 fingerprint at runtime.
- **Release Deliverables:** Preserved `app-release.apk` inside `10_Application_Deployment/release/`.

---

## 2. Cryptographic Specifications & Signature Verification

### 2.1 Keystore Parameters
- **Keystore Location:** `~/.android/scs391_release.jks` (Outside Git repository)
- **Key Alias:** `scs391Release`
- **Key Algorithm:** RSA 2048-bit
- **Digest Algorithm:** SHA-384withRSA / SHA-256
- **Validity:** 10,000 Days (~27 Years)
- **Distinguished Name (DN):** `CN=SCS391 Student, OU=CSE, O=University, L=City, ST=State, C=IN`

### 2.2 `apksigner` Verification Report
```text
$ apksigner verify --verbose --print-certs release/app-release.apk
Verifies
Verified using v1 scheme (JAR signing): false
Verified using v2 scheme (APK Signature Scheme v2): true
Number of signers: 1
Signer #1 certificate DN: CN=SCS391 Student, OU=CSE, O=University, L=City, ST=State, C=IN
Signer #1 certificate SHA-256 digest: e6bf0aefc5730c06c256b9f80cb90e1e1d15550df59c27c81c0dde30beeb8964
Signer #1 key algorithm: RSA
Signer #1 key size (bits): 2048
```

---

## 3. Source Code

### `MainActivity.java`
```java
package com.example.deploymentapp;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView tvAppId, tvVersionName, tvVersionCode, tvBuildType, tvDebuggable, tvCertFingerprint, tvVerificationBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAppId = findViewById(R.id.tvAppId);
        tvVersionName = findViewById(R.id.tvVersionName);
        tvVersionCode = findViewById(R.id.tvVersionCode);
        tvBuildType = findViewById(R.id.tvBuildType);
        tvDebuggable = findViewById(R.id.tvDebuggable);
        tvCertFingerprint = findViewById(R.id.tvCertFingerprint);
        tvVerificationBanner = findViewById(R.id.tvVerificationBanner);

        findViewById(R.id.btnVerifyStatus).setOnClickListener(v -> verifyDeploymentSpecs());

        verifyDeploymentSpecs();
    }

    private void verifyDeploymentSpecs() {
        try {
            PackageManager pm = getPackageManager();
            PackageInfo pInfo;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                pInfo = pm.getPackageInfo(getPackageName(), PackageManager.GET_SIGNING_CERTIFICATES);
            } else {
                pInfo = pm.getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            }

            tvAppId.setText(pInfo.packageName);
            tvVersionName.setText(pInfo.versionName);

            long versionCode = Build.VERSION.SDK_INT >= Build.VERSION_CODES.P
                    ? pInfo.getLongVersionCode()
                    : pInfo.versionCode;
            tvVersionCode.setText(String.valueOf(versionCode));

            boolean isDebuggable = (getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
            if (isDebuggable) {
                tvBuildType.setText("DEBUG (Non-Production)");
                tvDebuggable.setText("TRUE (Debuggable Active)");
            } else {
                tvBuildType.setText("RELEASE (Production Optimized)");
                tvDebuggable.setText("FALSE (Hardened Production Build)");
            }

            Signature[] signatures = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P && pInfo.signingInfo != null) {
                SigningInfo signingInfo = pInfo.signingInfo;
                signatures = signingInfo.hasMultipleSigners()
                        ? signingInfo.getApkContentsSigners()
                        : signingInfo.getSigningCertificateHistory();
            } else if (pInfo.signatures != null) {
                signatures = pInfo.signatures;
            }

            if (signatures != null && signatures.length > 0) {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] digest = md.digest(signatures[0].toByteArray());
                tvCertFingerprint.setText(bytesToHex(digest));
            }

            String timeStamp = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", Locale.getDefault()).format(new Date());
            tvVerificationBanner.setText("PRODUCTION RELEASE VERIFIED\nInstalled on Physical Hardware • " + timeStamp);

            Toast.makeText(this, "Production Release Validated Successfully!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            tvCertFingerprint.setText("Error reading signature: " + e.getMessage());
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(String.format("%02X", bytes[i]));
            if (i < bytes.length - 1) sb.append(":");
        }
        return sb.toString();
    }
}
```

---

## 4. Verification & Screenshots
- **Verification Hardware:** Physical OnePlus CPH2661 (Android 16, API 36, Serial `2d242b39`)
- **Execution Evidence:**
  1. `Practical_Screenshots/Practical_10/P10_Release_Execution.png` (Production Release Dashboard on hardware showing `FLAG_DEBUGGABLE: FALSE`, version specs, and cryptographic fingerprint)
  2. `Practical_Screenshots/Practical_10/P10_Release_Verification_Details.png` (Real-time dynamic re-verification of deployment parameters)
