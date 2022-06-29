
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
            version("version.androidx.compose", "_")
            version("version.androidx.lifecycle", "_")
            version("version.androidx.activity", "_")
            
            library("core-kts", "androidx.core", "core-ktx").versionRef("version.androidx.core")
            library("ui", "androidx.compose.ui", "ui").versionRef("version.androidx.compose")
            library("material", "androidx.compose.material", "material").versionRef("version.androidx.compose")
            library("ui-tooling-preview", "androidx.compose.ui", "ui-tooling-preview").versionRef("version.androidx.compose")
            library("lifecycle-runtime-ktx", "androidx.lifecycle", "lifecycle-runtime-ktx").versionRef("version.androidx.lifecycle")
            library("activity-compose", "androidx.activity", "activity-compose").versionRef("version.androidx.activity")
        }

        create("test") {
            version("version.junit.junit", "_")
            version("version.androidx.test.ext.junit", "_")
            version("version.androidx.test.espresso", "_")
            version("version.androidx.compose", "_")

            library("junit", "junit", "junit").versionRef("version.junit.junit")
            library("ext-junit", "androidx.test.ext", "junit").versionRef("version.androidx.test.ext.junit")
            library("espresso-core", "androidx.test.espresso", "espresso-core").versionRef("version.androidx.test.espresso")
            library("ui-test-junit4", "androidx.compose.ui", "ui-test-junit4").versionRef("version.androidx.compose")
            library("ui-tooling", "androidx.compose.ui", "ui-tooling").versionRef("version.androidx.compose")
            library("ui-test-manifest", "androidx.compose.ui", "ui-test-manifest").versionRef("version.androidx.compose")
        }
    }
}
rootProject.name = "BusbyFood"
include(":presentation")

