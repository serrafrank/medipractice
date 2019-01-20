#!/usr/bin/env bash

set -e

#./start.sh simple-service
./start.sh config-server
./start.sh discovery-server
./start.sh gateway-server
./start.sh datafile-service
./start.sh page-service
./start.sh clientui
