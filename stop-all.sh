#!/usr/bin/env bash

set -e

#./stop.sh simple-service
./stop.sh config-server
./stop.sh discovery-server
./stop.sh gateway-server
./stop.sh microservice-datafile
./stop.sh microservice-page
./stop.sh clientui
#./stop.sh oauth-server
