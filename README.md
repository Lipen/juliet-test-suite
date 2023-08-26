# Juliet Test Suite

[![Release](https://jitpack.io/v/Lipen/juliet-test-suite.svg)](https://jitpack.io/p/Lipen/juliet-test-suite)

A collection of test cases in the Java language. It contains examples for 112 different CWEs.
The test suite is taken from the [NIST website](https://samate.nist.gov/SRD/testsuite.php)

## Build

To build the Juliet Test Suite, simply execute the following command:

```sh
./gradlew build
```

Once built, you can locate the compiled JARs within `**/build/libs/*.jar`.

## Gradle dependency

Each CWE is available as a separate artifact on [JitPack](https://jitpack.io/):

```
repositories {
    maven(url = "https://jitpack.io/")
}

dependencies {
    // CWE476: NULL Pointer Dereference
    implementation("com.github.Lipen.juliet-test-suite:cwe476:$version")

    // Include the `support` module, if needed:
    implementation("com.github.Lipen.juliet-test-suite:support:$version")
}
```

You also have the option to include the entire repository as a dependency by adding `com.github.Lipen:juliet-test-suite:$version` to your project.
However, please be aware that the complete artifact, which includes all CWEs, is quite substantial in size, exceeding 60MB.
