plugins {
    id("com.android.application")
}

val releaseStoreFile = System.getenv("RELEASE_STORE_FILE")
    ?: "${System.getProperty("user.home")}/.android/scs391_release.jks"
val releaseStorePassword = System.getenv("RELEASE_STORE_PASSWORD")
    ?: "androidReleaseLab2026"
val releaseKeyAlias = System.getenv("RELEASE_KEY_ALIAS")
    ?: "scs391Release"
val releaseKeyPassword = System.getenv("RELEASE_KEY_PASSWORD")
    ?: "androidReleaseLab2026"

android {
    namespace = "com.example.deploymentapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.deploymentapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 100
        versionName = "1.0.0-release"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
            if (file(releaseStoreFile).exists()) {
                storeFile = file(releaseStoreFile)
                storePassword = releaseStorePassword
                keyAlias = releaseKeyAlias
                keyPassword = releaseKeyPassword
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            applicationIdSuffix = ".debug"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
}
