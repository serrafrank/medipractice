#!/usr/bin/env bash
set -e

# ANSI Colors
echoRed() { echo $'\e[0;31m'"$1"$'\e[0m'; }
echoGreen() { echo $'\e[0;32m'"$1"$'\e[0m'; }
echoYellow() { echo $'\e[0;33m'"$1"$'\e[0m'; }


if [ $# -eq 0 ]; then
    echoRed "No arguments provided"
    echoRed "usage: $0 [start|stop|restart|tail]"
    exit 1
fi

if [ "$0" == "start"]; then
    shift
    for rep in $*
    do
        serviceAction $rep start
    done
    exit 1
fi

if [ "$0" == "stop"]; then
    shift
    for rep in $*
    do
        serviceAction $rep stop
    done
    exit 1
fi




serviceAction(){
    export SERVICE=${1%/}
    export SERVICE_TARGET_DIR=$SERVICE*/target

    FILE=$SERVICE_TARGET_DIR/$SERVICE*-exec.jar

    if [ -f $FILE ]
    then
        . ./bash/env-$SERVICE*.sh
        ./$FILE ${2%/}
    else
        echoYellow "the jar file does not exist ($FILE)"
    fi
}