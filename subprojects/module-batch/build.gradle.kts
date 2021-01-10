dependencies {
    implementation("org.springframework.boot:spring-boot-starter-batch")
    testImplementation("org.springframework.batch:spring-batch-test")
    testCompile("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("com.h2database:h2")
    implementation("com.slack.api:slack-api-client:1.0.3")
    implementation(project(":module-core"))
    implementation(project(":module-domain"))
    implementation(project(":module-client"))
}
