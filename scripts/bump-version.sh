#!/usr/bin/env bash
set -euo pipefail

LEVEL=${1:-patch}

BUILD_FILE="build.gradle"
XML_FILE="src/main/resources/META-INF/plugin.xml"

current=$(grep "^version =" "$BUILD_FILE" | sed -E "s/.*'(.*)'/\1/")
IFS='.' read -r major minor patch <<< "$current"

case "$LEVEL" in
  patch)
    patch=$((patch + 1))
    ;;
  minor)
    minor=$((minor + 1))
    patch=0
    ;;
  major)
    major=$((major + 1))
    minor=0
    patch=0
    ;;
  *)
    echo "Unknown level: $LEVEL" >&2
    exit 1
    ;;
esac

new_version="$major.$minor.$patch"

sed -i -E "s/version = '.+'/version = '$new_version'/" "$BUILD_FILE"
sed -i -E "s#<version>[^<]+</version>#<version>$new_version</version>#" "$XML_FILE"

echo "Bumped version to $new_version"
