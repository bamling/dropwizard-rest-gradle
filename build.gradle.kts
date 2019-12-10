import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
    idea

    id("com.github.johnrengelman.shadow") version "5.2.0"
}

repositories {
    jcenter()
}

dependencies {
    // dropwizard dependencies
    implementation(platform("io.dropwizard:dropwizard-bom:2.0.0"))
    implementation("io.dropwizard:dropwizard-core")

    // testing dependencies
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.1")
}



tasks {
    named<ShadowJar>("shadowJar") {
        mergeServiceFiles()
        exclude("META-INF/*.DSA", "META-INF/*.RSA", "META-INF/*.SF")
        manifest {
            attributes(mapOf("Main-Class" to "com.github.bamling.dropwizard.petstore.PetStoreApplication"))
        }
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}
