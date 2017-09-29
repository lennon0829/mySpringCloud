FROM java:8
VOLUME /tmp
ADD hdServer.jar
RUN bash -c 'touch /hdServer.jar'
EXPOSE 8600
ENTRYPOINT ["java", "-jar", "hdServer.jar"]