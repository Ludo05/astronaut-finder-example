# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/gradle-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

spring-web
Who's in space
This spring boot application allows you to see who is in space right now.

### How to build use command
 `./gradlew clean build` from the root to run application.

### How to run use command
 `./gradlew clean bootRun` from the root to run application.

### Endpoints
Available endpoints

`/astronauts`
Returns full object of all astronauts in space with name and craft.

`/astronauts/amount`
Returns the number of astronauts in space

`/astronauts/all`
Returns an array astronaut name and craft

`/astronauts/all/ordered`
Returns list of astronaut name in order of last name.

`/astronauts/names`
Returns array of names of astronauts

`/astronauts/craft`
Returns array of crafts

`/astronauts/name/craft?name=Test`
Returns craft of name given

`/astronauts/craft-name?craft=ISS`
Returns astronauts that are on craft

`/astronauts/add`
Posts astronaut into local List

`/astronauts/load-local`
Returns list of local List

### Tests
Tests have been added to run against `Mockmvc`.