FROM java:8
VOLUME /tmp
ADD eurekaRegistry.jar
RUN bash -c 'touch /eurekaRegistry.jar'
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "eurekaRegistry.jar"]