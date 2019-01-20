#!/usr/bin/env bash
set -e

mvn clean package $1 -Dmaven.test.skip=true