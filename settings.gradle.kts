
enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

plugins {
    id("de.fayard.refreshVersions") version "0.40.2"
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {
            version("core-kts", "1.8.0")
            version("compose", "1.1.0")
            version("lifecycle-runtime-ktx", "2.4.1")
            version("activity-compose", "1.4.0")
            version("kotlinx-coroutines-core", "1.6.1")
            version("kotlin-stdlib", "1.6.21")
            version("dagger", "2.42")

            library("core-kts", "androidx.core", "core-ktx").versionRef("core-kts")
            library("ui", "androidx.compose.ui", "ui").versionRef("compose")
            library("material", "androidx.compose.material", "material").versionRef("compose")
            library("ui-tooling-preview", "androidx.compose.ui", "ui-tooling-preview").versionRef("compose")
            library("lifecycle-runtime-ktx", "androidx.lifecycle", "lifecycle-runtime-ktx").versionRef("lifecycle-runtime-ktx")
            library("activity-compose", "androidx.activity", "activity-compose").versionRef("activity-compose")

            library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef("kotlinx-coroutines-core")
            library("kotlin-stdlib","org.jetbrains.kotlin", "kotlin-stdlib").versionRef("kotlin-stdlib")
            library("dagger", "com.google.dagger", "dagger").versionRef("dagger")

            bundle("compose", listOf("ui", "material", "ui-tooling-preview", "activity-compose"))
        }

        create("test") {
            version("junit", "4.13.2")
            version("ext-junit", "1.1.3")
            version("espresso-core", "3.4.0")
            version("compose", "1.1.0")

            library("junit", "junit", "junit").versionRef("junit")
            library("ext-junit", "androidx.test.ext", "junit").versionRef("ext-junit")
            library("espresso-core", "androidx.test.espresso", "espresso-core").versionRef("espresso-core")
            library("ui-test-junit4", "androidx.compose.ui", "ui-test-junit4").versionRef("compose")
            library("ui-tooling", "androidx.compose.ui", "ui-tooling").versionRef("compose")
            library("ui-test-manifest", "androidx.compose.ui", "ui-test-manifest").versionRef("compose")
        }
    }
}
rootProject.name = "BusbyFood"
include(":presentation", ":domain", ":data")

