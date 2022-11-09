import io.gitlab.arturbosch.detekt.Detekt

buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.3.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.version.kotlin.get()}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${libs.versions.version.google.dagger.get()}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${libs.versions.version.kotlin.get()}")
        classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.19.0")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("io.gitlab.arturbosch.detekt") version "1.19.0"
}

apply(plugin = "io.gitlab.arturbosch.detekt")

/*
tasks.withType<Detekt>().configureEach {
    reports {
        xml.required.set(true)
        html.required.set(true)
        txt.required.set(true)
        sarif.required.set(true)
    }
}
*/

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
