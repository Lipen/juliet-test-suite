plugins {
    `java-library`
}

dependencies {
    implementation(project(":utils"))
    compileOnly("javax.servlet:javax.servlet-api:4.0.1")
}
