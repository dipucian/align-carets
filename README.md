# align-carets
align-carets plugin for intellij

it works by inserting spaces to match the right most caret

### Version bumps

Use the **Bump Version** workflow in GitHub Actions to create a pull request
that increments the plugin version. The workflow accepts a `patch`, `minor` or
`major` level and lists recent commit titles in the PR description.

### Publishing

To publish the plugin, run `./gradlew publishPlugin` with the `PUBLISH_TOKEN` environment variable set to a JetBrains Marketplace token. In GitHub Actions, add this variable as a repository secret so that it is available during the publish step.

### Local installation

After building the project with `./gradlew buildPlugin`, the plugin archive is
created in `build/distributions`. In IntelliJ IDEA use *Install Plugin from
Disk...* from the Plugins settings and choose the ZIP file.

GitHub Actions also attaches this ZIP file as a workflow artifact for each
successful build, so it can be downloaded from a branch's workflow run.

