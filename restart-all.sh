#!/usr/bin/env bash
set -e

# ANSI Colors
echoRed() { echo $'\e[0;31m'"$1"$'\e[0m'; }
echoGreen() { echo $'\e[0;32m'"$1"$'\e[0m'; }
echoYellow() { echo $'\e[0;33m'"$1"$'\e[0m'; }


echoYellow "### stop all ###"
./stop-all.sh
echoYellow "### clean & build all with '$1' ###"
./build-all.sh $1
echoYellow "### start all ###"
./start-all.sh
