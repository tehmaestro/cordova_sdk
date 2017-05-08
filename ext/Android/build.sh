#!/usr/bin/env bash
# - Build the JAR file by running the following Gradle tasks
#   - clean
#   - clearJar
#   - makeJar
# - Copy the JAR file to the root dir

OUT_DIR=./adjust/build/outputs

# Get the script directory and Traverse up to get to the root SDK directory
SDK_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
SDK_DIR="$(dirname "$SDK_DIR")"
SDK_DIR="$(dirname "$SDK_DIR")" 

# cd to the called directory to be able to run the script from anywhere
cd $SDK_DIR/ext/android/sdk/Adjust

./gradlew clean clearJar makeJar
mv -v ${OUT_DIR}/*.jar $SDK_DIR/ext/Android/adjust-android.jar
