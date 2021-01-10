val queryDslVersion: String by rootProject.extra
val modelMapperVersion: String by rootProject.extra
val sentryVersion: String by rootProject.extra

dependencies {
    implementation(project(":module-core"))
    implementation(project(":module-domain"))
    api("org.springframework:spring-web")
}

tasks {
    bootJar {
        enabled = false
    }

    jar {
        enabled = true
    }
}