all: build

build:
	./mvnw clean compile package -DskipTests
	mv target/util.jar .

run: build
	java -jar util.jar
