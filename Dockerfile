FROM openjdk:11
COPY "./target/webflux-facturas-0.0.1-SNAPSHOT.jar" "facturas.jar"
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "facturas.jar"]