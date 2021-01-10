val ktLintVersion by extra { "0.36.0" }
val queryDslVersion by extra { "4.2.2" }
val modelMapperVersion by extra { "2.3.0" }
val sentryVersion by extra { "1.7.30" }

plugins {
    val kotlinVersion = "1.3.61"

    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    id("org.springframework.boot") version "2.2.4.RELEASE" apply false
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    if (project.childProjects.isNotEmpty() || displayName == "project ':protocol'") {
        return@subprojects
    }

    apply {
        plugin("idea")
        plugin("kotlin")
        plugin("kotlin-kapt")
        plugin("kotlin-spring")
        plugin("kotlin-jpa")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }

    allOpen {
        annotation("javax.persistence.Entity")
        annotation("javax.persistence.MappedSuperclass")
        annotation("javax.persistence.Embeddable")
    }

    group = "kr.co.socarcorp"
    version = "0.0.1-SNAPSHOT"

    val ktLintDependency by configurations.creating

    dependencies {
        implementation(kotlin("reflect"))
        implementation(kotlin("stdlib-jdk8"))
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

        testImplementation("org.junit.jupiter:junit-jupiter")

        ktLintDependency("com.pinterest:ktlint:$ktLintVersion")
    }

    tasks {
        val ktLint by registering(JavaExec::class) {
            classpath = ktLintDependency
            main = "com.pinterest.ktlint.Main"
            args = listOf("src/**/*.kt")
            description = "Check Kotlin code style."
        }

        register<JavaExec>("ktlintFormat") {
            classpath = ktLintDependency
            main = "com.pinterest.ktlint.Main"
            args = listOf("-F", "src/**/*.kt")
            description = "Fix Kotlin code style deviations."
        }

        compileKotlin {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict", "-Xuse-experimental=kotlin.Experimental")
                jvmTarget = "1.8"
            }

            dependsOn(ktLint)
        }

        compileTestKotlin {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict", "-Xuse-experimental=kotlin.Experimental")
                jvmTarget = "1.8"
            }
        }

        test {
            useJUnitPlatform()
        }
    }
}

tasks {
    jar.get().enabled = false
}