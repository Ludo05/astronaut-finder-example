# Astronaut Finder

Allows you to check what astronauts are in space right now

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