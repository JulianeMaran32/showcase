# imagem base da imagem do Docker
FROM adoptopenjdk/openjdk:17-jdk-alpine
LABEL authors="juliane.maran"

# instala o Maven no contêiner.
RUN apk update && apk --no-cache maven

# instla o curl no contêiner
# O curl é um utilitário de linha de comando que pode ser usado para transferir dados por meio de uma conexão HTTP.
#RUN apt-get update && apt-get install -y curl

# define o diretório de trabalho do contêiner
WORKDIR /app

# copia os arquivos do projeto para o contêiner
COPY target/showcase-0.0.1-SNAPSHOT.jar app.jar

# constrói a aplicação usando o Maven
RUN mvn clean install

# define os comandos que serão executados quando o contêiner for iniciado
ENTRYPOINT ["java", "-jar", "target/showcase-0.0.1-SNAPSHOT.jar"]