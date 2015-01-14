FROM nginx

MAINTAINER Per Abich <per.abich@gmail.com>

COPY html /usr/share/nginx/html
COPY default.conf /etc/nginx/conf.d/default.conf

EXPOSE 80
COPY entrypoint.sh /
ENTRYPOINT ["/entrypoint.sh"]