FROM java:8
VOLUME /tmp
ADD zuulGateway.jar
RUN bash -c 'touch /zuulGateway.jar'
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "zuulGateway.jar"]