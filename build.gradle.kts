import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlin.plugin.serialization") version Deps.kotlinVersion
}

group = "io.peekandpoke.kraft.examples"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
//    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
//
    mavenLocal()
}

kotlin {
    js {
        browser {
            binaries.executable()

            // Add webpack configuration
            commonWebpackConfig {
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).copy(
                    port = 55002
                )
            }
        }
    }

    sourceSets {
        jsMain {
            dependencies {
                implementation(Deps.KotlinLibs.Kraft.semanticui)
            }
        }
    }
}
