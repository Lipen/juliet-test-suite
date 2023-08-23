plugins {
    `java-library`
}

dependencies {
    implementation(project(":utils"))
    compileOnly("javax.servlet:javax.servlet-api:4.0.1")
    implementation("commons-lang:commons-lang:2.6")
}
