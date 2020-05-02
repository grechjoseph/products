FROM openjdk:12-alpine
COPY target/customer-products-assignment-application.jar /customer-products-assignment-application.jar
CMD ["java", "-jar", "/customer-products-assignment-application.jar"]