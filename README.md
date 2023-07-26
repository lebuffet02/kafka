# kafka-spring


CMD 1:
C:\Users\???\kafka\bin\windows>zookeeper-server-start.bat ../../config/zookeeper.properties

CMD 2:
C:\Users\???\kafka\bin\windows>kafka-server-start.bat ../../config/server.properties


CMD 3:
C:\Users\???\kafka\bin\windows>kafka-topics.bat --bootstrap-server localhost:9092 --describe
C:\Users\???\kafka\bin\windows>kafka-topics.bat --bootstrap-server localhost:9092 --topic compras.do.cliente --create --partitions 1

CRIAR NOVO TOPICO
C:\Users\???\kafka\bin\windows>kafka-topics.bat --bootstrap-server localhost:9092 --create --topic ecommerce.cliente2 --partitions 1 --replication-factor 1