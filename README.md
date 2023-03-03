# quarkus-rest-panache

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## API test in POSTMAN

1. get all list data
   use method GET
```shell script
  http://localhost:8080/product
```

2. create a new data
   use method POST
```shell script
  http://localhost:8080/product
  
  send data in body raw json : 
  {
    "product_name":"your product",
    "merk":"jarss",               // default "no merk"
    "description":"description",  // default "no description"
    "category":"category",        // default "no category"
    "price":2000000,              // default 0
    "quantity":19                 // default 0
}
```
3. read specific data
   use method GET
```shell script
  http://localhost:8080/product/{product_name}
```

4. update data
   use method PUT
```shell script
  http://localhost:8080/product/{product_name}
  
  send data in body raw json : 
  {
    "product_name":"your product",
    "merk":"jarss",               // default "no merk"
    "description":"description",  // default "no description"
    "category":"category",        // default "no category"
    "price":2000000,              // default 0
    "quantity":19                 // default 0
}
```

5. delete data
   use method DELETE
```shell script
  http://localhost:8080/product/{product_name}
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-rest-panache-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

[Related Hibernate with Panache section...](https://quarkus.io/guides/hibernate-orm-panache)


### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
