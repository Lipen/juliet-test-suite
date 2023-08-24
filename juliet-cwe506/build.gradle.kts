plugins {
    `java-library`
}

dependencies {
    implementation(project(":utils"))
    compileOnly(Libs.JavaxServlet.javax_servlet_api)
    implementation(Libs.JavaxMail.mail)
    implementation(Libs.CommonsCodec.commons_codec)
}
