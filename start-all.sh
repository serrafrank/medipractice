#!/usr/bin/env bash

set -e

#./start.sh simple-service
./start.sh config-server
./start.sh discovery-server
./start.sh gateway-server
./start.sh microservice-datafile
./start.sh microservice-page
./start.sh clientui
