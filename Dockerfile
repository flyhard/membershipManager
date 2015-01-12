FROM debian:latest
MAINTAINER Per Abich<per.abich@gmail.com>

RUN apt-get update && \
    apt-get upgrade && \
    apt-get install java