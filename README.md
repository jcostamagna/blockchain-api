# Blockchain Api

![technology Gradle](https://img.shields.io/badge/technology-Gradle-blue.svg)

This is a Java Gradle application where users can see statistics about crypto market. This REST API it's integrated with [Blockchain.com Exchange API](https://api.blockchain.info/v3/).

## Considerations

- Application run in only one mode. There is no Dev or Prod profile at the moment.
- Default setting for HTTP request are used at the moment.
- No tests added at the moment. 

# Docker Compose

## Run the System
We can run the whole with only a command:
```bash
docker-compose up
```


The services can be run on the background with command:
```bash
docker-compose up -d
```

## Stop the System
Stopping all the running containers is also with a single command:
```bash
docker-compose down
```

If you need to stop and remove all containers, networks, and all images used by any service in <em>docker-compose.yml</em> file, use the command:
```bash
docker-compose down --rmi all
```

## How to run the application locally

1. Install [Java 11](https://oracle.com/ar/java/technologies/javase/jdk11-archive-downloads.html) and [Gradle 7.4.1](https://docs.gradle.org/7.4.1/release-notes.html)

2. Download the [Blockchain Api](https://github.com/jcostamagna/blockchain-api) GitHub repository

3. Go to the project's root and run:

   `./gradlew clean build`

   `java -jar build/libs/blockchain-api-0.0.1.jar com.jcostamagna.blockchainapi.BlockchainApiApplication`

## API Endpoints

### Get all order book statistics

```
GET /exchanges/blockchain/order-books
```

it returns the statistics of all symbols:

```
{
    "orderBookAvg": [
        {
            "symbol": "EOS-USDC",
            "bids": {
                "priceAverage": 0.0,
                "quantityAverage": 0.0
            },
            "asks": {
                "priceAverage": 0.0,
                "quantityAverage": 0.0
            }
        },
        ...
    ]
}
```


### Get order book statistics from symbol
```
GET /exchanges/blockchain/order-books/GRT-USD
```

where "GRT-USD" is a symbol example.

it returns the statistics for that symbol:

```
{
    "symbol": "GRT-USD",
    "bids": {
        "priceAverage": 0.10327736842105263,
        "quantityAverage": 3291.55416795
    },
    "asks": {
        "priceAverage": 0.1144188888888889,
        "quantityAverage": 3153.8554185800003
    }
}
```


## Questions

* [costamagna.jic@gmail.com](costamagna.jic@gmail.com)