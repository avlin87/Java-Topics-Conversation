drop schema if exists liadov CASCADE;
drop user if exists usr;

create user usr with password 'pass';
create schema liadov authorization usr;