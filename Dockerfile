FROM debian:latest
MAINTAINER Per Abich<per.abich@gmail.com>


RUN echo "deb http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main" | tee /etc/apt/sources.list.d/webupd8team-java.list
RUN echo "deb-src http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main" | tee -a /etc/apt/sources.list.d/webupd8team-java.list
RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys EEA14886
RUN apt-get update
RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections
RUN apt-get install -y oracle-java8-installer
RUN apt-get upgrade -y
ADD src pom.xml *.yml /usr/src/app/
WORKDIR /usr/src/app
RUN apt-get install -y oracle-java8-set-default maven && \
    mvn install && \
    apt-get purge -y maven && \
    apt-get autoclean
