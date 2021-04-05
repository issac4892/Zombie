import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "io.github.issac4892"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    implementation("com.destroystokyo.paper:paper-api:1.13.2-R0.1-SNAPSHOT") // Paper
    implementation(kotlin("stdlib"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    processResources {
        filesMatching("**/*.yml") {
            expand(project.properties)
        }
    }
    shadowJar {
        archiveClassifier.set("dist")
        archiveVersion.set("")
    }
    create<Copy>("dist") {
        from(shadowJar)
        into(".\\") // Directly into code root directory.
    }
}