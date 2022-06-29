
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

            alias("core-kts").to("androidx.core", "core-ktx").versionRef("kts")
        }
    }
}
rootProject.name = "BusbyFood"
include(":presentation")

