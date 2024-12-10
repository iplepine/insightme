import com.jyoon.configureKotlinMultiplatform
import com.jyoon.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

/**
 * Kotlin Multiplatform 에서 플랫폼 의존성 없는 Module 에서 사용
 * core:kotlin 은 build.gradle 이 따로 구성 되어 있음
 */
class KotlinMultiplatformConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(libs.findPlugin("kotlinMultiplatform").get().get().pluginId)
            apply(libs.findPlugin("kotlinSerialization").get().get().pluginId)
        }

        // Add dependency on core:kotlin project
        dependencies.apply {
            add("commonMainImplementation", project(":core:kotlin"))
        }

        extensions.configure<KotlinMultiplatformExtension>(::configureKotlinMultiplatform)
    }
}