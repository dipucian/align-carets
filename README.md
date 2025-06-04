# align-carets
align-carets plugin for intellij

it works by inserting spaces to match the right most caret

### Publishing

The Gradle build uses the `publishPlugin` task. Authentication details are
read from the environment variables `PLUGIN_USERNAME` and `PLUGIN_PASSWORD`.
In GitHub Actions, add these as repository secrets and they will be available
when the plugin is published.
