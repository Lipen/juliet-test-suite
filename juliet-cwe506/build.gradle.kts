plugins {
    `java-library`
}

dependencies {
    implementation(project(":utils"))
    compileOnly("javax.servlet:javax.servlet-api:4.0.1")
    implementation("javax.mail:mail:1.4.7")
    implementation("commons-codec:commons-codec:1.16.0")
}
