FROM gradle:7.4-jdk-jammy

WORKDIR /blockchain-app

COPY . .

RUN gradle clean build

CMD ["java", "-jar", "-Djava.rmi.server.hostname=localhost", "build/libs/blockchain-api-0.0.1.jar", "com.jcostamagna.blockchainapi.BlockchainApiApplication"]
