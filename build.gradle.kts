plugins {
    `java-library`
    `maven-publish`
    with(Plugins.Shadow) { id(id) version (version) }
}

group = "juliet"
version = "1.3.1"

subprojects {
    // group = "${rootProject.group}.${rootProject.name}"
    group = rootProject.group
    version = rootProject.version
}

allprojects {
    apply(plugin = "java-library")
    apply(plugin = "maven-publish")

    repositories {
        mavenCentral()
    }

    java {
        // withSourcesJar()
        // withJavadocJar()
    }

    publishing {
        publications {
            create<MavenPublication>("maven") {
                from(components["java"])
            }
        }
        repositories {
            maven(url = uri(layout.buildDirectory.dir("repository")))
        }
    }
}

dependencies {
    for (p in subprojects) {
        implementation(p)
    }
}

tasks.wrapper {
    gradleVersion = "8.3"
    distributionType = Wrapper.DistributionType.ALL
}
