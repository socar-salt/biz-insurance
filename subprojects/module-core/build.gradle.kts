val queryDslVersion: String by rootProject.extra
val modelMapperVersion: String by rootProject.extra
val sentryVersion: String by rootProject.extra

dependencies {
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.springframework.data:spring-data-envers")
    kapt("org.springframework.boot:spring-boot-configuration-processor")
    compileOnly("org.springframework.boot:spring-boot-configuration-processor")
    runtimeOnly("mysql:mysql-connector-java")
    implementation("org.modelmapper:modelmapper:$modelMapperVersion")
    implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.5.6")
    implementation("io.sentry:sentry-spring-boot-starter:$sentryVersion")
    implementation("io.sentry:sentry-logback:$sentryVersion")
}

tasks {
    bootJar {
        enabled = false
    }

    jar {
        enabled = true
    }
}