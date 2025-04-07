#!/bin/sh
# The set -e command makes the script exit immediately if any command fails (returns a non-zero exit code).
set -e

# Initialize PostgreSQL if not already initialized
if [ ! -s "$PGDATA/PG_VERSION" ]; then
    echo "Initializing PostgreSQL database..."
    initdb -D "$PGDATA"
# host all all 0.0.0.0/0 trust: This configuration allows connections to PostgreSQL from any
# IP address (0.0.0.0/0) without requiring a password (i.e., the trust method).
# You should be cautious in production environments due to potential security risks.
    echo "host all all 0.0.0.0/0 trust" >> "$PGDATA/pg_hba.conf"
    echo "listen_addresses='*'" >> "$PGDATA/postgresql.conf"
     # Create the default database
    echo "Creating database $POSTGRES_DB..."
    pg_ctl start -D "$PGDATA" -w

# Create the default database if it doesn't exist
    echo "Creating database $POSTGRES_DB..."
    psql -U postgres <<-EOSQL
        CREATE DATABASE "$POSTGRES_DB";
        GRANT ALL PRIVILEGES ON DATABASE "$POSTGRES_DB" TO "$POSTGRES_USER";
EOSQL

    # Stop PostgreSQL after the database is created
    pg_ctl stop -D "$PGDATA" -m fast

# This closes the if block, ending the conditional check for whether PostgreSQL needs to be initialized.
fi

# Execute the command passed to the container (if arguments were passed to the script)
exec "$@"