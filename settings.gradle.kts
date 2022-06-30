
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
            version("version.androidx.core", "_")
            version("version.androidx.compose.ui", "_")
            version("version.androidx.compose.material", "_")
            version("version.androidx.compose.compiler", "_")
            version("version.androidx.lifecycle", "_")
            version("version.androidx.activity", "_")
            version("version.kotlinx.coroutines", "_")
            version("version.kotlin", "_")
            version("version.google.dagger", "_")
            version("version.androidx.room","_")
            version("version.androidx.datastore", "_")

            library("core-kts", "androidx.core", "core-ktx").versionRef("version.androidx.core")

            library("ui", "androidx.compose.ui", "ui").versionRef("version.androidx.compose.ui")
            library("material", "androidx.compose.material", "material").versionRef("version.androidx.compose.material")
            library("ui-tooling-preview", "androidx.compose.ui", "ui-tooling-preview").versionRef("version.androidx.compose.ui")
            library("lifecycle-runtime-ktx", "androidx.lifecycle", "lifecycle-runtime-ktx").versionRef("version.androidx.lifecycle")
            library("activity-compose", "androidx.activity", "activity-compose").versionRef("version.androidx.activity")

            library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef("version.kotlinx.coroutines")
            library("kotlin-stdlib","org.jetbrains.kotlin", "kotlin-stdlib").versionRef("version.kotlin")

            library("dagger", "com.google.dagger", "dagger").versionRef("version.google.dagger")
            library("hilt-android","com.google.dagger", "hilt-android").versionRef("version.google.dagger")
            library("hilt-android-compiler","com.google.dagger", "hilt-android-compiler").versionRef("version.google.dagger")

            library("room-runtime", "androidx.room", "room-runtime").versionRef("version.androidx.room")
            library("room-compiler","androidx.room", "room-compiler").versionRef("version.androidx.room")
            library("room-ktx","androidx.room","room-ktx").versionRef("version.androidx.room")

            library("datastore-preferences","androidx.datastore", "datastore-preferences").versionRef("version.androidx.datastore")

            bundle("compose", listOf("ui", "material", "ui-tooling-preview", "activity-compose"))
            bundle("dagger", listOf("dagger", "hilt-android", "hilt-android-compiler"))
            bundle("room", listOf("room-runtime", "room-compiler", "room-ktx"))
        }

        create("test") {
            version("version.junit.junit", "_")
            version("version.androidx.test.ext.junit", "_")
            version("version.androidx.test.espresso", "_")
            version("version.androidx.compose.ui", "_")

            library("junit", "junit", "junit").versionRef("version.junit.junit")
            library("ext-junit", "androidx.test.ext", "junit").versionRef("version.androidx.test.ext.junit")
            library("espresso-core", "androidx.test.espresso", "espresso-core").versionRef("version.androidx.test.espresso")
            library("ui-test-junit4", "androidx.compose.ui", "ui-test-junit4").versionRef("version.androidx.compose.ui")
            library("ui-tooling", "androidx.compose.ui", "ui-tooling").versionRef("version.androidx.compose.ui")
            library("ui-test-manifest", "androidx.compose.ui", "ui-test-manifest").versionRef("version.androidx.compose.ui")
        }
    }
}
rootProject.name = "BusbyFood"
include(":presentation", ":domain", ":data")

