plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "me.androidbox.busbyfood"
        minSdk = 24
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.corekts)
    implementation(libs.ui)
    implementation(libs.material)
    implementation(libs.uitoolingpreview)
    implementation(libs.lifecycleruntimektx)
    implementation(libs.activitycompose)

    testImplementation(test.junit)
    androidTestImplementation(test.extjunit)
    androidTestImplementation(test.espressocore)
    androidTestImplementation(test.uitestjunit4)
    debugImplementation(test.uitooling)
    debugImplementation(test.uitestmanifest)
}