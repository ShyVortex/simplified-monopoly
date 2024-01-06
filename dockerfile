FROM maven:latest

# Install X11 dependencies
RUN apt-get -y update && \
    apt-get install -y libxrender1 libxtst6 libxi6 && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory
WORKDIR .

# Copy the entire project into the container
COPY . .

# Build the project with Maven
RUN mvn clean package

# CMD to run the Java application
CMD ["java", "-jar", "target/simplified-monopoly-2.1.3.jar"]

