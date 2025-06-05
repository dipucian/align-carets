# align-carets
align-carets plugin for intellij

it works by inserting spaces to match the right most caret

### Publishing

To publish the plugin, run `./gradlew publishPlugin` with the `PUBLISH_TOKEN` environment variable set to a JetBrains Marketplace token. In GitHub Actions, add this variable as a repository secret so that it is available during the publish step.

### Gradle wrapper

This repository does not include the `gradle-wrapper.jar` file. To generate it,
run:

```bash
gradle wrapper --gradle-version 8.14 --distribution-type bin
```

This command downloads the required wrapper files so `./gradlew` works.

### Local installation

After building the project with `./gradlew buildPlugin`, the plugin archive is
created in `build/distributions`. In IntelliJ IDEA use *Install Plugin from
Disk...* from the Plugins settings and choose the ZIP file.

GitHub Actions also attaches this ZIP file as a workflow artifact for each
successful build, so it can be downloaded from a branch's workflow run.

