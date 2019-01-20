#!/usr/bin/env bash

set -e

#./stop.sh simple-service
./stop.sh config-server
./stop.sh discovery-server
./stop.sh gateway-server
./stop.sh datafile-service
./stop.sh page-service
./stop.sh clientui
#./stop.sh oauth-server
