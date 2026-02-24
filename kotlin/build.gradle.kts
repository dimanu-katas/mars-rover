plugins {
    kotlin("jvm") version "2.2.20"
    id("com.diffplug.spotless") version "7.0.2"
}

group = "org.dimanu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allprojects {
    apply(plugin = "kotlin")
    apply(plugin = "com.diffplug.spotless")

    dependencies {
        implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        testImplementation("org.jetbrains.kotlin:kotlin-test")
        testImplementation("io.mockk:mockk:1.13.5")
    }

    configure<com.diffplug.gradle.spotless.SpotlessExtension> {
        kotlin {
            ktlint().editorConfigOverride(
                mapOf(
                    "insert_final_newline" to "true",
                ),
            )
        }
        kotlinGradle {
            ktlint()
        }
    }

    tasks.check {
        dependsOn("spotlessCheck")
    }

    tasks.test {
        useJUnitPlatform()
        include("**/*Test.class*", "**/*Should.class*")
        testLogging { events("passed", "skipped", "failed") }
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_21.toString()
        targetCompatibility = JavaVersion.VERSION_21.toString()
    }
}
