FROM java:8
MAINTAINER Per Abich <per.abich@gmail.com>

ADD src pom.xml *.yml /usr/src/app/
WORKDIR /usr/src/app
RUN apt-get update && \
    apt-get install -y maven && \
    mvn install && \
    apt-get purge -y maven && \
    apt-get autoclean && \
    apt-get upgrade -y && \
    rm -rf ~/.m2 && \
    mkdir -p /opt/app && \
    mv target/membership-register*.jar /opt/app && \
    rm -rf target
    
WORKDIR /opt/app
CMD java -jar /opt/app/memebership*.jar