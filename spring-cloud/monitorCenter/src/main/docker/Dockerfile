FROM java:8
VOLUME /tmp
ADD monitorCenter.jar
RUN bash -c 'touch /monitorCenter.jar'
EXPOSE 8600
ENTRYPOINT ["java", "-jar", "monitorCenter.jar"]