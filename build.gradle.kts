plugins {
    id("java")
}

group = "com.cozystudios.fofrathzindustry"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.github.Auburn:FastNoiseLite:1.0.2")
}

tasks.test {
    useJUnitPlatform()
}