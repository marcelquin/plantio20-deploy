FROM maven:3.9-amazoncorretto-21 AS build

# Definindo diretório de trabalho
WORKDIR /app

# Copiando arquivos de configuração do Maven primeiro (para cache de dependências)
COPY pom.xml .
COPY src ./src

# Compilando a aplicação
RUN mvn clean package -DskipTests

# Imagem de execução
FROM amazoncorretto:21-alpine

# Metadados
# Definindo diretório de trabalho
WORKDIR /app

# Copiando o JAR gerado na fase de build
COPY --from=build /app/target/*.jar app.jar

# Expondo a porta padrão do Spring Boot
EXPOSE 8080

# Definindo ponto de entrada
ENTRYPOINT ["java", "-jar", "app.jar"]

# Parâmetros para a JVM (opcional)
# Para ajustar conforme necessidade da aplicação
ENV JAVA_OPTS="-Xms256m -Xmx512m"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]