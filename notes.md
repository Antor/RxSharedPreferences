Q: How to upgrade to newer version of Gradle?
A: Run in terminal: `./gradlew wrapper --gradle-version 5.1.1`
   Instead of `5.1.1` substitute appropriate version number.
   
Q: Where to find more information about `gradle-versions-plugin`?
A: https://github.com/ben-manes/gradle-versions-plugin

Q: How to check project dependencies for updates?
A: Run next command in terminal: `./gradlew clean dependencyUpdates`

Q: How to publish to Maven local repository?
A: Run next command in terminal: `./gradlew clean build publishToMavenLocal`

Q: How to publish to Bintray Maven repository?
A: Run next command in terminal: `./gradlew clean build bintrayUpload`