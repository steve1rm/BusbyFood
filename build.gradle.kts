buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${plugins.versions.plugin.android.get()}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.version.kotlin.get()}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${libs.versions.version.google.dagger.get()}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${libs.versions.version.kotlin.get()}")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.application") apply false
    id("com.android.library") apply false
    id("org.jetbrains.kotlin.android") apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
