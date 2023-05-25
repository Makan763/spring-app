# Utilisation d'une image Java 8 comme base
FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=target/*.jar

# Installation du client MySQL
RUN apk add --no-cache mysql-client

# Création du répertoire d'application
RUN mkdir -p /app

# Définition du répertoire de travail
WORKDIR /app

# Copie des fichiers de l'application
COPY target/kubernetes.jar /app
COPY src/main/resources/application.properties /app

# Configuration de l'application pour MySQL
ENV SPRING_DATASOURCE_URL=jdbc:mysql://db_host:3306/geststudent?useSSL=false
ENV SPRING_DATASOURCE_USERNAME=makan
ENV SPRING_DATASOURCE_PASSWORD=123456

# Exécution de l'application lors du lancement du conteneur
CMD ["java", "-jar","/app/kubernetes.jar"]
