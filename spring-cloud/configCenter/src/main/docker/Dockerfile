FROM java:8
VOLUME /tmp
ADD configCenter.jar
RUN bash -c 'touch /configCenter.jar'
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "configCenter.jar"]