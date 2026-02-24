# Standard Configuration

If Gradle is not already installed, you can do it following the instructions in the [Gradle Installation Guide](https://gradle.org/install/).

Once you have Gradle installed, you can go to any kata and build it using the following command:

```shell
gradle build
```

# Running the Tests

To run the tests, you can use the following command:

```shell
gradle test
```

To run a specific test from a specific class, you can use the following command:

```shell
gradle test --tests "com.dimanu.katas.kataName.className.methodName"
```