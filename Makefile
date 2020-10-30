.PHONY: default test docker-test docker-build
default: docker-test

test:
	mvn test

docker-build:
	docker build . -t kata-java

docker-test:
	@docker run --rm -v ${PWD}:/opt/project -v ${PWD}/../.m2:/root/.m2 -w /opt/project kata-java make test
