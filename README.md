# simpleendpoints project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `simpleendpoints-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/simpleendpoints-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/simpleendpoints-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Container image creation

You can check the original documents in [here](https://quarkus.io/guides/container-image)

First, include the docker extension. You can use an alternative extension.
```
./mvnw quarkus:add-extension -Dextensions="container-image-docker"
```

And then, build the image

``` 
./mvnw clean package -Dquarkus.container-image.build=true

```

## Native image container creation
It takes a long time.

```
./mvnw package -Pnative -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true
```

But the image is thiner

```
docker image ls
REPOSITORY                           TAG                 IMAGE ID       CREATED              SIZE
yo/simpleendpoints                   1.0.0-SNAPSHOT      4202d87e3896   About a minute ago   384MB
```

```
docker image ls
REPOSITORY                                 TAG                 IMAGE ID       CREATED          SIZE
yo/simpleendpoints                         1.0.0-SNAPSHOT      7f2ffeb77337   5 minutes ago    134MB
```

### Kubernetes Kind
If you want to use that image in a Kind cluster, you can use the following

``` 
kind load docker-image yo/simpleendpoints:1.0.0-SNAPSHOT
```

## Environment variables in docker

```
docker create -env JAVA_HOME=/opt/java/ -p 9001:8080 --name my-container yo/simpleendpoints:1.0.0-SNAPSHOT
```

# RESTEasy JAX-RS

<p>A Hello World RESTEasy resource</p>

Guide: https://quarkus.io/guides/rest-json

# Resources List

* `GET /randomString` returns a json including a random String

* `GET /environmentVariable/{environmentVariableName}` returns a json including a random String and the value of that environment variable.
