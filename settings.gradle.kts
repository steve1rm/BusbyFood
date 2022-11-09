
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
        createLibs()
        createTest()

        create("plugins") {
            version("plugin.android", "_")
        }
    }
}
rootProject.name = "BusbyFood"
include(":presentation", ":domain", ":data")

fun MutableVersionCatalogContainer.createTest() {
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

fun MutableVersionCatalogContainer.createLibs() {
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
        version("version.retrofit2", "_")
        version("version.androidx.hilt", "_")
        version("version.retrofit2-kotlin-coroutines-adapter", "_")
        version("version.okhttp3", "_")
        version("version.coil-kt", "_")
        version("version.androidx.core-splashscreen", "_")
        version("version.androidx.navigation-compose", "_")
        version("version.androidx.paging", "_")
        version("version.detekt-gradle-plugin", "_")

        library("core-kts", "androidx.core", "core-ktx").versionRef("version.androidx.core")

        library("ui", "androidx.compose.ui", "ui").versionRef("version.androidx.compose.ui")
        library("material", "androidx.compose.material", "material").versionRef("version.androidx.compose.material")
        library("ui-tooling-preview", "androidx.compose.ui", "ui-tooling-preview").versionRef("version.androidx.compose.ui")
        library("lifecycle-runtime-ktx", "androidx.lifecycle", "lifecycle-runtime-ktx").versionRef("version.androidx.lifecycle")
        library("activity-compose", "androidx.activity", "activity-compose").versionRef("version.androidx.activity")
        library("core-splashscreen","androidx.core", "core-splashscreen").versionRef("version.androidx.core-splashscreen")
        library("navigation-compose","androidx.navigation", "navigation-compose").versionRef("version.androidx.navigation-compose")
        library("paging-compose", "androidx.paging", "paging-compose").versionRef("version.androidx.compose.ui")
        library("paging-common","androidx.paging", "paging-common").versionRef("version.androidx.paging")

        library("kotlinx-coroutines-core", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef("version.kotlinx.coroutines")
        library("kotlin-stdlib","org.jetbrains.kotlin", "kotlin-stdlib").versionRef("version.kotlin")

        library("dagger", "com.google.dagger", "dagger").versionRef("version.google.dagger")
        library("hilt-android","com.google.dagger", "hilt-android").versionRef("version.google.dagger")
        library("hilt-android-compiler","com.google.dagger", "hilt-android-compiler").versionRef("version.google.dagger")
        library("hilt-compiler","androidx.hilt", "hilt-compiler").versionRef("version.androidx.hilt")

        library("room-runtime", "androidx.room", "room-runtime").versionRef("version.androidx.room")
        library("room-compiler","androidx.room", "room-compiler").versionRef("version.androidx.room")
        library("room-ktx","androidx.room","room-ktx").versionRef("version.androidx.room")
        library("room-paging", "androidx.room", "room-paging").versionRef("version.androidx.room")

        library("datastore-preferences","androidx.datastore", "datastore-preferences").versionRef("version.androidx.datastore")

        library("retrofit", "com.squareup.retrofit2", "retrofit").versionRef("version.retrofit2")
        library("retrofit2-kotlin-coroutines-adapter", "com.jakewharton.retrofit", "retrofit2-kotlin-coroutines-adapter").versionRef("version.retrofit2-kotlin-coroutines-adapter")
        library("converter-moshi", "com.squareup.retrofit2", "converter-moshi").versionRef("version.retrofit2")
        library("logging-interceptor", "com.squareup.okhttp3", "logging-interceptor").versionRef("version.okhttp3")

        library("coil-compose", "io.coil-kt", "coil-compose").versionRef("version.coil-kt")
        library("detekt-gradle-plugin","io.gitlab.arturbosch.detekt", "detekt-gradle-plugin").versionRef("version.detekt-gradle-plugin")

        bundle("compose", listOf("ui", "material", "ui-tooling-preview", "activity-compose", "navigation-compose", "paging-compose"))
        bundle("dagger", listOf("dagger", "hilt-android", "hilt-android-compiler"))
        bundle("room", listOf("room-runtime", "room-compiler", "room-ktx"))
    }
}
