FROM java:8
USER root
WORKDIR /opt
COPY docker-entrypoint.sh /opt/docker-entrypoint.sh
COPY target/hotel-shop-third-mock.jar /opt/app.jar
ENV SPRING_PROFILES_ACTIVE dev
ENV EUREKA_HOST 192.168.5.123
EXPOSE 8777
ENTRYPOINT ["/opt/docker-entrypoint.sh"]