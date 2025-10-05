import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.TaskContainerScope
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

@Suppress("MemberVisibilityCanBePrivate")
object Deps {
    operator fun invoke(block: Deps.() -> Unit) {
        this.block()
    }

    // Kotlin ////////////////////////////////////////////////////////////////////////////////////
    const val kotlinVersion = "2.2.20"

    object Ksp {
        // https://github.com/google/ksp/releases
        const val version = "2.2.20-2.0.3"
        const val symbol_processing = "com.google.devtools.ksp:symbol-processing-api:$version"

        // https://mvnrepository.com/artifact/com.github.tschuchortdev/kotlin-compile-testing
        private const val compiletesting_version = "1.6.0"
        const val compiletesting = "com.github.tschuchortdev:kotlin-compile-testing:$compiletesting_version"
        const val compiletesting_ksp = "com.github.tschuchortdev:kotlin-compile-testing-ksp:$compiletesting_version"
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////

    // JVM ///////////////////////////////////////////////////////////////////////////////////////
    val jvmTarget = JvmTarget.JVM_17
    val jvmTargetVersion = jvmTarget.target.toInt()
    // ///////////////////////////////////////////////////////////////////////////////////////////

    // Dokka /////////////////////////////////////////////////////////////////////////////////////
    // https://mvnrepository.com/artifact/org.jetbrains.dokka/dokka-gradle-plugin
    // Dokka gradle plugin org.jetbrains.dokka
    const val dokkaVersion = "2.0.0" // kotlinVersion
    // ///////////////////////////////////////////////////////////////////////////////////////////

    // Publishing ////////////////////////////////////////////////////////////////////////////////
    // https://search.maven.org/artifact/com.vanniktech/gradle-maven-publish-plugin
    const val mavenPublishVersion = "0.30.0"
    // ///////////////////////////////////////////////////////////////////////////////////////////

    object KotlinLibs {
        // https://central.sonatype.com/artifact/io.peekandpoke.ultra/common
        private const val ultra_version = "0.94.1"

        object Ultra {
            const val common = "io.peekandpoke.ultra:common:$ultra_version"
            const val html = "io.peekandpoke.ultra:html:$ultra_version"
            const val logging = "io.peekandpoke.ultra:logging:$ultra_version"
            const val kontainer = "io.peekandpoke.ultra:kontainer:$ultra_version"
            const val meta = "io.peekandpoke.ultra:meta:$ultra_version"
            const val security = "io.peekandpoke.ultra:security:$ultra_version"
            const val semanticui = "io.peekandpoke.ultra:semanticui:$ultra_version"
            const val slumber = "io.peekandpoke.ultra:slumber:$ultra_version"
            const val streams = "io.peekandpoke.ultra:streams:$ultra_version"
            const val vault = "io.peekandpoke.ultra:vault:$ultra_version"
        }

        object Kraft {
            const val core = "io.peekandpoke.kraft:core:$ultra_version"
            const val semanticui = "io.peekandpoke.kraft:semanticui:$ultra_version"
            const val testing = "io.peekandpoke.kraft:testing:$ultra_version"

            const val addons_chartjs = "io.peekandpoke.kraft:addons-chartjs:$ultra_version"
            const val addons_konva = "io.peekandpoke.kraft:addons-konva:$ultra_version"
            const val addons_marked = "io.peekandpoke.kraft:addons-marked:$ultra_version"
            const val addons_nxcompile = "io.peekandpoke.kraft:addons-nxcompile:$ultra_version"
            const val addons_pdfjs = "io.peekandpoke.kraft:addons-pdfjs:$ultra_version"
            const val addons_prismjs = "io.peekandpoke.kraft:addons-prismjs:$ultra_version"
            const val addons_signaturepad = "io.peekandpoke.kraft:addons-signaturepad:$ultra_version"
            const val addons_sourcemappedstacktrace =
                "io.peekandpoke.kraft:addons-sourcemappedstacktrace:$ultra_version"
        }

        object Funktor {
            const val all = "io.peekandpoke.funktor:all:$ultra_version"
            const val core = "io.peekandpoke.funktor:core:$ultra_version"
            const val cluster = "io.peekandpoke.funktor:cluster:$ultra_version"
            const val logging = "io.peekandpoke.funktor:logging:$ultra_version"
            const val insights = "io.peekandpoke.funktor:insights:$ultra_version"
            const val rest = "io.peekandpoke.funktor:rest:$ultra_version"
            const val staticweb = "io.peekandpoke.funktor:staticweb:$ultra_version"
            const val messaging = "io.peekandpoke.funktor:messaging:$ultra_version"
            const val testing = "io.peekandpoke.funktor:testing:$ultra_version"
        }

        object Karango {
            const val core = "io.peekandpoke.karango:core:$ultra_version"
            const val addons = "io.peekandpoke.karango:addons:$ultra_version"
            const val ksp = "io.peekandpoke.karango:ksp:$ultra_version"
        }

        // https://mvnrepository.com/artifact/com.github.ajalt.clikt/clikt
        private const val clikt_version = "5.0.3"
        const val clikt = "com.github.ajalt.clikt:clikt:$clikt_version"

        // https://mvnrepository.com/artifact/com.github.doyaaaaaken/kotlin-csv
        private const val csv_version = "1.10.0"
        const val csv = "com.github.doyaaaaaken:kotlin-csv:$csv_version"

        // https://mvnrepository.com/artifact/io.github.evanrupert/excelkt
        private const val excelkt_version = "1.0.2"
        const val excelkt = "io.github.evanrupert:excelkt:$excelkt_version"

        // https://mvnrepository.com/artifact/com.benasher44/uuid
        private const val uuid_version = "0.8.4"
        const val uuid = "com.benasher44:uuid:$uuid_version"

        // https://mvnrepository.com/artifact/io.github.g0dkar/qrcode-kotlin
        private const val qrcode_version = "4.5.0"
        const val qrcode = "io.github.g0dkar:qrcode-kotlin:$qrcode_version"

        // https://mvnrepository.com/artifact/io.github.serpro69/kotlin-faker
        private const val faker_version = "1.16.0"
        const val faker = "io.github.serpro69:kotlin-faker:$faker_version"
    }

    // // NPM dependencies /////////////////////////////////////////////////////////////////////////

    object Npm {
        operator fun <T> invoke(block: Npm.() -> T): T {
            return this.block()
        }
    }

    // // Test dependencies ////////////////////////////////////////////////////////////////////////

    object Test {

        operator fun invoke(block: Test.() -> Unit) {
            this.block()
        }

        // https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
        const val logback_version = "1.5.19"
        const val logback_classic = "ch.qos.logback:logback-classic:$logback_version"

        // https://mvnrepository.com/artifact/io.kotest/kotest-common
        const val kotest_plugin_version = "6.0.3"
        const val kotest_version = "6.0.3"

        const val kotest_assertions_core = "io.kotest:kotest-assertions-core:$kotest_version"
        const val kotest_framework_api = "io.kotest:kotest-framework-api:$kotest_version"
        const val kotest_framework_datatest = "io.kotest:kotest-framework-datatest:$kotest_version"
        const val kotest_framework_engine = "io.kotest:kotest-framework-engine:$kotest_version"

        const val kotest_runner_junit_jvm = "io.kotest:kotest-runner-junit5-jvm:$kotest_version"

        fun KotlinDependencyHandler.commonTestDeps() {
            kotlin("test-common")
            kotlin("test-annotations-common")
            implementation(kotest_assertions_core)
            implementation(kotest_framework_api)
            implementation(kotest_framework_datatest)
            implementation(kotest_framework_engine)
        }

        fun KotlinDependencyHandler.jsTestDeps() {
            implementation(kotest_assertions_core)
            implementation(kotest_framework_api)
            implementation(kotest_framework_datatest)
            implementation(kotest_framework_engine)
        }

        fun KotlinDependencyHandler.jvmTestDeps() {
            implementation(logback_classic)
            implementation(kotest_runner_junit_jvm)
            implementation(kotest_assertions_core)
            implementation(kotest_framework_api)
            implementation(kotest_framework_datatest)
            implementation(kotest_framework_engine)
        }

        fun DependencyHandlerScope.jvmTestDeps() {
            testImplementation(logback_classic)
            testImplementation(kotest_runner_junit_jvm)
            testImplementation(kotest_assertions_core)
            testImplementation(kotest_framework_api)
            testImplementation(kotest_framework_engine)
        }

        fun TaskContainerScope.configureJvmTests(
            configure: org.gradle.api.tasks.testing.Test.() -> Unit = {}
        ) {
            listOfNotNull(
                findByName("test") as? org.gradle.api.tasks.testing.Test,
                findByName("jvmTest") as? org.gradle.api.tasks.testing.Test,
            ).firstOrNull()?.apply {
                useJUnitPlatform { }

                filter {
                    isFailOnNoMatchingTests = false
                }

//                testLogging {
//                    showExceptions = true
//                    showStandardStreams = true
//                    events = setOf(
//                        org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
//                        org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
//                    )
//                    exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
//                }

                configure()
            }
        }
    }
}

private fun DependencyHandlerScope.testImplementation(dep: String) =
    add("testImplementation", dep)
