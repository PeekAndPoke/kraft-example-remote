plugins {
    kotlin("js")
    id("org.jetbrains.kotlin.plugin.serialization") version Deps.kotlinVersion
}

group = "io.peekandpoke.kraft.examples"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    // KotlinX
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
}

dependencies {
    api(Deps.ultra_common_mp)
    api(Deps.kraft_core)
}

kotlin {
    js(IR) {
        browser {
        }

        binaries.executable()
    }
}
