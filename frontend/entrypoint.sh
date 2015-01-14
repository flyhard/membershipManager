#!/bin/bash

set -e

echo $*

if [[ -z "$1" ]]
then
    if [[ -z "$DROPWIZARD_PORT_8080_TCP_ADDR" && -z "$DROPWIZARD_PORT_8080_TCP_PORT" ]]
    then
        echo "Missing link to DROPWIZARD container. Please run with --link <name>:dropwizard"
        exit 1
    fi
fi

exec "$@"