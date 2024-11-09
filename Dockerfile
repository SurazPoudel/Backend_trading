# Use a multi-stage build for caching dependencies
FROM maven:3.8.4-openjdk-17 AS builder

# Copy only the POM file to cache dependencies
WORKDIR /build
COPY pom.xml .

# Download and cache dependencies
RUN mvn dependency:go-offline

# Copy the rest of the application source and build the JAR
COPY . .
RUN mvn package -DskipTests

# Use a smaller base image for the final build
FROM builder AS final

# Set working directory
WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=builder /build/target/trading-platform.jar .

# Expose port and define environment variable
EXPOSE 5454
ENV SERVER_PORT=5454
ENV SPRING_PROFILES_ACTIVE=prod
# Command to run the application
CMD ["java", "-jar", "trading-platform.jar"]
