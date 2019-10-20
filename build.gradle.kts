import io.spring.gradle.dependencymanagement.DependencyManagementPlugin
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin

plugins {
    base
    kotlin("jvm") version "1.2.71" apply false
    id("io.spring.dependency-management") version "1.0.8.RELEASE" apply false
}

allprojects {
    group = "com.resume"
    version = "0.0.1-version"

    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
    }
}
