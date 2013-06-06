# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table "SECURE_SOCIAL_TOKENS" ("UUID" VARCHAR NOT NULL PRIMARY KEY,"EMAIL" VARCHAR NOT NULL,"CREATION_TIME" TIMESTAMP NOT NULL,"EXPIRATION_TIME" TIMESTAMP NOT NULL,"IS_SIGN_UP" BOOLEAN NOT NULL);
create table "SECURE_SOCIAL_USERS" ("U_ID" VARCHAR NOT NULL,"PROVIDER_ID" VARCHAR NOT NULL,"EMAIL" VARCHAR,"FIRST_NAME" VARCHAR NOT NULL,"LAST_NAME" VARCHAR NOT NULL,"AUTH_METHOD" VARCHAR NOT NULL,"HASHER" VARCHAR,"PASSWORD" VARCHAR,"SALT" VARCHAR);
create table "TASKS" ("id" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL PRIMARY KEY,"label" VARCHAR NOT NULL);

# --- !Downs

drop table "SECURE_SOCIAL_TOKENS";
drop table "SECURE_SOCIAL_USERS";
drop table "TASKS";

