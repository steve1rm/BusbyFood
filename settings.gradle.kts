
enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {
            version("kts", "1.8.0")
            version("compose", "1.1.0")
            version("lifecycle-runtime-ktx", "2.4.1")
            version("activity-compose", "1.4.0")

            alias("corekts").to("androidx.core", "core-ktx").versionRef("kts")
            alias("ui").to("androidx.compose.ui", "ui").versionRef("compose")
            alias("material").to("androidx.compose.material", "material").versionRef("compose")
            alias("uitoolingpreview").to("androidx.compose.ui", "ui-tooling-preview").versionRef("compose")
            alias("lifecycleruntimektx").to("androidx.lifecycle", "lifecycle-runtime-ktx").versionRef("lifecycle-runtime-ktx")
            alias("activitycompose").to("androidx.activity", "activity-compose").versionRef("activity-compose")
        }

        create("test") {
            version("junit", "4.13.2")
            version("extjunit", "1.1.3")
            version("espresso-core", "3.4.0")
            version("compose", "1.1.0")

            alias("junit").to("junit", "junit").versionRef("junit")
            alias("extjunit").to("androidx.test.ext", "junit").versionRef("extjunit")
            alias("espressocore").to("androidx.test.espresso", "espresso-core").versionRef("espresso-core")
            alias("uitestjunit4").to("androidx.compose.ui", "ui-test-junit4").versionRef("compose")
            alias("uitooling").to("androidx.compose.ui", "ui-tooling").versionRef("compose")
            alias("uitestmanifest").to("androidx.compose.ui", "ui-test-manifest").versionRef("compose")
        }
    }
}
rootProject.name = "BusbyFood"
include(":presentation")

