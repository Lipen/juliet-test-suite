plugins {
    `java-library`
}

dependencies {
    implementation(project(":utils"))
    compileOnly(Libs.JavaxServlet.javax_servlet_api)
}
