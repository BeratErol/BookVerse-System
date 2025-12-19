# Build aşaması: Uygulamayı derlemek için Maven ve JDK kullanılır
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
# Maven ile projeyi paketle ve testleri atla
RUN mvn clean package -DskipTests

# Run aşaması: Uygulamayı çalıştırmak için daha hafif olan JRE kullanılır
# Run aşaması için sadece JRE içeren daha küçük bir imaj kullan
FROM eclipse-temurin:17-jre-focal
# Build aşamasında oluşan JAR dosyasını kopyala ve adını app.jar yap
COPY --from=build /target/*.jar app.jar
# Konteyner başlatıldığında çalıştırılacak komut
ENTRYPOINT ["java","-jar","/app.jar"]