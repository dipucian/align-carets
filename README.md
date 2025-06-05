# align-carets
align-carets plugin for intellij

it works by inserting spaces to match the right most caret

### Version bumps

Use the **Bump Version** workflow in GitHub Actions to create a pull request
that increments the plugin version. The workflow accepts a `patch`, `minor` or
`major` level and lists recent commit titles in the PR description.

### Publishing

The Gradle build uses the `publishPlugin` task. Authentication details are
read from the environment variable `PUBLISH_TOKEN`. In GitHub Actions add this
secret so the publish workflow can deploy the plugin once a version bump PR is
merged.

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

