#!/usr/bin/env bash

export MODE=service
WORKING_DIR="$(pwd)"

export JARFILE=$WORKING_DIR/$APP_NAME/target/$APP_NAME*-exec.jar
export PID_FOLDER=$WORKING_DIR/$APP_NAME/target/
export LOG_FOLDER=$WORKING_DIR/$APP_NAME/target/



