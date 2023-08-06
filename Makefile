build-image:
	cd ./springboot/ &&  mvn clean package dockerfile:build
	cd ./quarkus/ && mvn clean package && docker build -f src/main/Docker/Dockerfile.jvm -t  demo-quarkus:0.0.1 .

run-with-docker:
	docker-compose up -d