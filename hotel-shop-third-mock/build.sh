#!/bin/sh
mvn clean package -X -Dtest.skip=true
docker rm $(docker ps --filter ancestor=api-mock:latest -q)
docker rmi $(docker images -f "reference=api-mock" -q)
docker build -t api-mock .
