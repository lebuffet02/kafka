# kafka-spring


### CMD 1:

```sh
C:\Users\???\kafka\bin\windows>zookeeper-server-start.bat ../../config/zookeeper.properties
```


### CMD 2:

```sh
C:\Users\???\kafka\bin\windows>kafka-server-start.bat ../../config/server.properties
```


### CMD 3:

```sh
C:\Users\???\kafka\bin\windows>kafka-topics.bat --bootstrap-server localhost:9092 --describe
```

```sh
C:\Users\???\kafka\bin\windows>kafka-topics.bat --bootstrap-server localhost:9092 --topic compras.do.cliente --create --partitions 1
```


### CRIAR NOVO TOPICO

```sh
C:\Users\???\kafka\bin\windows>kafka-topics.bat --bootstrap-server localhost:9092 --create --topic ecommerce.cliente2 --partitions 1 --replication-factor 1
```


