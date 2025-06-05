# align-carets
align-carets plugin for intellij

it works by inserting spaces to match the right most caret

### Publishing

The Gradle build uses the `publishPlugin` task. Authentication details are
read from the environment variables `PLUGIN_USERNAME` and `PLUGIN_PASSWORD`.
In GitHub Actions, add these as repository secrets and they will be available
when the plugin is published.

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

