#!/usr/bin/env bash

# Exit if any errors occur
# set -e

# Get the current directory (/scripts/ directory)
SCRIPTS_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

# Traverse up to get to the root directory
ROOT_DIR="$(dirname "$SCRIPTS_DIR")"
EXAMPLE_DIR=example_ci
SDK_NAME=com.adjust.sdk
TESTING_PLUGIN_NAME=com.adjust.sdktesting

RED='\033[0;31m' 	# Red color
GREEN='\033[0;32m' 	# Green color
NC='\033[0m' 		# No Color

echo -e "${GREEN}>>> Removing cordova plugins ${NC}"
cd ${ROOT_DIR}/${EXAMPLE_DIR}
cordova plugin rm ${SDK_NAME}
cordova plugin rm ${TESTING_PLUGIN_NAME}
cordova plugin rm cordova-plugin-console
cordova plugin rm cordova-plugin-customurlscheme
cordova plugin rm cordova-plugin-dialogs
cordova plugin rm cordova-plugin-whitelist
cordova plugin rm cordova-plugin-device
cordova plugin rm cordova-universal-links-plugin

rm -rv plugins/${SDK_NAME}
rm -rv plugins/${TESTING_PLUGIN_NAME}

cordova platform remove ios
cordova platform remove android
