# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-alpine

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo .jar generado al contenedor
COPY dist/todoapp-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que la aplicación se ejecuta
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]