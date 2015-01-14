FROM java:8
MAINTAINER Per Abich <per.abich@gmail.com>

COPY pom.xml *.yml /usr/src/app/
COPY src/ /usr/src/app/src
WORKDIR /usr/src/app
RUN apt-get update && \
    apt-get install -y maven && \
    mvn install && \
    apt-get purge -y maven && \
    apt-get autoclean && \
    rm -rf ~/.m2 && \
    mkdir -p /opt/app && \
    mv target/membership-register*.jar /opt/app && \
    rm -rf target && \
    update-alternatives --set java /usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java

RUN java -version

WORKDIR /opt/app
CMD java -jar /opt/app/membership*.jar server