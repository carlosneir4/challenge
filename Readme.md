# Challenge
Challenge is a spring boot application try to resolve below exercise

1. download apache kafka locally, (just need to unzip) and run it (zookeeper & kafka servers)
2. create 1 kafka topic called "novice-players"

3. create the controllers, services, repositories and entities needed to do the following:

- a POST endpoint that receives an array of players
```{
     "players": [
       {
         "name": "Sub zero",
         "type": "expert"
       },
       {
         "name": "Scorpion",
         "type": "novice"
       },
       {
         "name": "Reptile",
         "type": "meh"
       }
     ]
   }
```

- for each "player" object you need to check its "type" property
  - if it is "expert" you need to store the player in a H2 database.
  - if it is "novice" you need to send that object via a kafka event to the "novice-players" topic
  - if the type does not fit one of the above, you will let the user know in the endpoint response

the response for the above payload would be:

```{
     "result": [
       "player Sub zero stored in DB",
       "player Scorpion sent to Kafka topic",
       "player Reptile did not fit"
     ]
   }
``` 

#### Full Documentation

- Lombok [more info...](https://projectlombok.org/features/all) [How to configure...](https://www.baeldung.com/lombok-ide)
- kafka Quick start (kafka_2.13-2.7.0) [more info...](https://kafka.apache.org/quickstart)
```
Create topic
bin/kafka-topics.sh --create --topic novice-players --bootstrap-server localhost:9092
open consumer 
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic novice-players --from-beginning
```
- Java 11
- springboot intr with (h2,spring web, data jpa, spring kafka)

####Getting started

```
$ git clone https://github.com/carlosneir4/challenge.git
$ cd challenge/
```

We need to install maven or add it to our IDE, also we should configure lombok to run JUnits.

####Build

```
$ mvn compile test package
$ java -jar target/challenge-0.0.1-SNAPSHOT.jar
or
$ mvn spring-boot:run
```
#### Local RestApi endpoints


```
curl --location --request POST 'http://localhost:8080/player/classify' \
   --header 'Content-Type: application/json' \
   --data-raw '{
      "players":[
         {
            "name":"Sub zero",
            "type":"expert"
         },
         {
            "name":"Scorpion",
            "type":"novice"
         },
         {
            "name":"",
            "type":"meh"
         },
               {
            "name":"Sub zero",
            "type":"expert"
         },
         {
            "name":"Scorpion",
            "type":"novice"
         },
         {
            "name":"blahh",
            "type":"meh"
         }
      ]
   }'
```