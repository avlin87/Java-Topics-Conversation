# Java-Topics-Conversation

## Start application from docker:

### Docker database initialization:

- run following command `podman build -t my-postgres-image .` to create docker image in **docker** folder
- run `podman run -p 5433:5432 my-postgres-image` to start container for local run

### Start App container and DB container:

- Create a Podman network `podman network create my-network`
- Start PostgreSQL container on network 'my-network' inside of **docker** folder
    - `podman run -d --name my-postgres --network my-network -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=epamcourses -p 5433:5432  my-postgres-image`
- update `localhost` to `my-postgres` in configurations
- Prepare app for container:
    - `mvn clean package` to get jar
    - `podman build -t my-spring-app .` - build app container
- Run app Container
    - `podman run -d --name my-spring-app --network my-network -p 8080:8080 my-spring-app` - run container in network
- `podman ps` - to see the list of running containers