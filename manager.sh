#!/usr/bin/env bash
set -e

# ANSI Colors
echoRed() { echo $'\e[0;31m'"$1"$'\e[0m'; }
echoGreen() { echo $'\e[0;32m'"$1"$'\e[0m'; }
echoYellow() { echo $'\e[0;33m'"$1"$'\e[0m'; }

functionAction(){
    if [ $# -eq 0 ]
    then
        echoRed "No arguments provided"
        echoRed "usage: $0 [start|stop|restart|tail]"
        exit 1
    fi
    export SERVICE=${1%/}
    shift

    for rep in $*
    do
        export SERVICE_TARGET_DIR=$SERVICE*/target

        FILE=$SERVICE_TARGET_DIR/$SERVICE*-exec.jar

        if [ -f $FILE ]
        then
            . ./bash/env-$SERVICE*.sh
            ./$FILE ${2%/}
        else
            echoYellow "the jar file does not exist ($FILE)"
        fi
     done
}

functionStartAll(){
    functionAction start config-server discovery-server gateway-server auth-service datafile-service page-service clientui
}

functionStopAll(){
    functionAction stop config-server discovery-server gateway-server auth-service datafile-service page-service clientui
}

functionBuild(){
    mvn clean package $1 -Dmaven.test.skip=true
}


if [ $# -eq 0 ]
then
    echoRed "No arguments provided"
    echoRed "usage: $0 [start|stop|restart|tail]"
fi




if [ "$1" = "start" ]
then
    shift

    if [ "$1" = "all" ]
    then
        functionStartAll
    else
        functionAction start $*
    fi
    exit 1
fi

if [ "$1" = "-stop" ]
then
    shift

    if [ "$1" = "-all" ]
    then
        functionStartAll
    else
        functionAction stop $rep
    fi
    exit 1
fi

if [ "$1" = "build" ]
then
    functionBuild
    exit 1
fi


if [ "$1" = "restart-all" ]
then
    echoYellow "### stop all ###"
    functionStopAll
    echoYellow "### clean & build all with '$1' ###"
    functionBuild
    echoYellow "### start all ###"
    functionStartAll
    exit 1
fi

echoYellow "### stop all ###"
./stop-all.sh
echoYellow "### clean & build all with '$1' ###"
./build-all.sh $1
echoYellow "### start all ###"
./start-all.sh
