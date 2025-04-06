FROM openjdk:17
EXPOSE 8086
ADD target/livraisonMicro-0.0.1-SNAPSHOT.jar Livraison.jar
ENTRYPOINT ["java","-jar","Livraison.jar"]