plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    jvm() // 테스트 할려면 이것도 필요하다.... jvm 환경에서만 제공..
    listOf(iosArm64(), iosSimulatorArm64())

    sourceSets {
        commonMain.dependencies {
            api(libs.kotlinx.coroutines.core)
            api(libs.koin.core)
            api(libs.kotlinx.datetime)
        }

        commonTest.dependencies {
            api(libs.junit)
            api(kotlin("test"))
            api(libs.kotlinx.coroutines.test)
        }
    }
}