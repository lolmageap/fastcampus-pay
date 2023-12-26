plugins {
    id("java")
}

group = "com.payment"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}