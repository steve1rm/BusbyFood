plugins {
    id("java-library")
    id("kotlin")
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlin.stdlib)
    implementation(libs.dagger)
    implementation(libs.paging.common)

    testImplementation(test.junit)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}