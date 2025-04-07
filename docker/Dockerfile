# Use Alpine as the base image
FROM alpine:3.18

# Set environment variables for PostgreSQL
ENV POSTGRES_USER=postgres \
    POSTGRES_PASSWORD=postgres \
    POSTGRES_DB=epamcourses \
    PGDATA=/var/lib/postgresql/data

# Install PostgreSQL and dependencies
RUN apk update && \
    apk add --no-cache postgresql postgresql-client su-exec bash && \
    mkdir -p /run/postgresql && \
    chown -R postgres:postgres /run/postgresql

# Initialize the data directory
RUN mkdir -p $PGDATA && \
    chown -R postgres:postgres /var/lib/postgresql

# Copy entrypoint script
COPY docker-entrypoint.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/docker-entrypoint.sh

# Switch to postgres user
USER postgres

# Expose PostgreSQL port
EXPOSE 5432

# Set the entrypoint
ENTRYPOINT ["/usr/local/bin/docker-entrypoint.sh"]

# Default command
CMD ["postgres"]
