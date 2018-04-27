FROM java:8
VOLUME /tmp
ADD zipkinServer.jar
RUN bash -c 'touch /zipkinServer.jar'
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "zipkinServer.jar"]