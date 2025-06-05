# Agent Notes

This repository uses Gradle for builds. Helpful commands:

- Run tests:
  ```bash
  ./gradlew test --no-daemon
  ```
- Build the plugin locally:
  ```bash
  ./gradlew buildPlugin
  ```
- Publish the plugin to the JetBrains Marketplace:
  ```bash
  PUBLISH_TOKEN=<token> ./gradlew publishPlugin
  ```
  `PUBLISH_TOKEN` is a token from the JetBrains Marketplace. Add it as a GitHub
  Actions secret for CI publishing.
