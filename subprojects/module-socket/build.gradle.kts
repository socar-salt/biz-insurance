dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testCompile("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("com.h2database:h2")
    implementation(project(":module-core"))
    implementation(project(":module-domain"))
    implementation(project(":module-client"))
}
