# backend-blog-projekt


### API Endpoints
This service exposes several API endpoints, to get an overview use the included OpenAPI specification file at [http://localhost:8080/q/dev-ui/io.quarkus.quarkus-smallrye-openapi/swagger-ui](http://localhost:8080/q/dev-ui/io.quarkus.quarkus-smallrye-openapi/swagger-ui) 
You can also explore the API interactively using the included Swagger UI at http://localhost:8080/q/dev-ui/io.quarkus.quarkus-smallrye-openapi/swagger-ui
The following endpoints are available:

| Method | Endpoint | Description |
| ------ | ------- | ----------- |
| GET    | /author| Get all authors |
| GET    | /author/{id} | Get author by id |
| POST   | /author | Create new author |
| DELETE | /author/{id} | Delete author by id |
| GET    | /blog | Get all blogposts |
| GET    | /blog/{id} | Get blogpost by id |
| POST   | /blog | Create new blogpost |
| DELETE | /blog/{id} | Delete blogpost by id |
| GET| /blog/count | Get number of blogposts |


This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./gradlew build
```
It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/backend-blog-projekt-0.0.1-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling.

## Related Guides


## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
