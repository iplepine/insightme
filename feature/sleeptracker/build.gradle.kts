plugins {
    alias(libs.plugins.jyoon.composeMultiplatform)
}

android {
    namespace = "com.jyoon.insightme.feature.sleeptracker"
}

kotlin {
    sourceSets {
        commonTest {
            dependencies {
                implementation(libs.kotlinx.datetime)
            }
        }
    }
}