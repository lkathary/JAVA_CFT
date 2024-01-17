all: build

build:
	./mvnw clean compile package -DskipTests
	mv target/util.jar .

run: build
	java -jar util.jar -s -f -p sample- in1.txt in2.txt
