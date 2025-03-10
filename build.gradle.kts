plugins {
    kotlin("jvm") version "2.0.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    compileOnly("org.projectlombok:lombok:1.18.36")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.12.0")
    testImplementation("org.assertj:assertj-core:3.27.3")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}