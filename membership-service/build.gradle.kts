import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("com.palantir.docker") version "0.35.0"
}

apply(plugin = "kotlin-jpa")
apply(plugin = "com.palantir.docker")

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project("path" to ":common"))

    runtimeOnly("com.mysql:mysql-connector-j")
}

docker {
    name = "${project.rootProject}-${project.name}:$version"
    setDockerfile(file("./Dockerfile"))
    tasks.getByName<BootJar>("bootJar").outputs.files
    buildArgs(
        mapOf(
            "JAR_FILE" to tasks.named<BootJar>("bootJar").get().archiveFileName.get()
        )
    )
}