
## Esempio 

```shell

docker network create net-kafka
# alternativa come immagine: apache/kafka-native:3.9.0
docker run -d --hostname kafka01 --name kafka01 -p 9092:9092 --network net-kafka apache/kafka:3.9.0

# TEMINALE PER ENTRARE COME ROOT e installare pacchetti vari
docker exec -u root -it kafka01 /bin/bash
apk update
apk search htop
apk add htop
apk add nano


# TERMINALE PER CREAZIONE TOPIC e PRODUCER
docker exec -it kafka01 /bin/bash
# nel terminale kafka
cd opt/kafka/
bin/kafka-topics.sh --create --topic test-corso --bootstrap-server localhost:9092
bin/kafka-topics.sh --describe --topic test-corso --bootstrap-server localhost:9092
bin/kafka-console-producer.sh --topic test-corso --bootstrap-server localhost:9092

# TERMINALE PER CONSUMER
docker exec -it kafka01 /bin/bash
cd /opt/kafka/
bin/kafka-console-consumer.sh --topic test-corso --from-beginning --bootstrap-server localhost:9092




# TERMINALE PER PRODUCER CONNECT 2
docker exec -it kafka01 /bin/bash
echo "plugin.path=libs/connect-file-3.9.0.jar" >> config/connect-standalone.properties
echo -e "msg1\nmsg2\nmsg3\nmsg3\nmsg4\nmsg5\nmsg6\nmsg7\nmsg8\nmsg9\nmsg10\nmsg11" > test.txt
bin/connect-standalone.sh config/connect-standalone.properties config/connect-file-source.properties config/connect-file-sink.properties
# per aggiungere, dopo aver creato il consumer 2, nuovi messaggi
echo "altro messaggio" >> test.txt

# TERMINALE PER CONSUMER 2
docker exec -it kafka01 /bin/bash
cd /opt/kafka/
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic connect-test --from-beginning 

```
