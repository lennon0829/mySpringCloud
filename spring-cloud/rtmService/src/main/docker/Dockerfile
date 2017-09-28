FROM java:8
VOLUME /tmp
ADD rtmService.jar
RUN bash -c 'touch /rtmService.jar'
EXPOSE 8600
ENTRYPOINT ["java", "-jar", "rtmService.jar"]