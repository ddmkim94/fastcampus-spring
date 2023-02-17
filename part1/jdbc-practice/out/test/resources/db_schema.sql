DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS(
    userId varchar(12) not null,
    password varchar(12) not null,
    name varchar(12) not null,
    email varchar(50),

    primary key (userId)
);