CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE person (
                        id uuid PRIMARY KEY,
                        name varchar(50),
                        surname varchar(50),
                        age integer,
                        sex varchar(10),
                        marital varchar(20),
                        dependents_amount integer,
                        phone_number varchar(30));

CREATE TABLE additional_contact (
                                    id uuid PRIMARY KEY,
                                    name varchar(50),
                                    surname varchar(50),
                                    last_name varchar(50),
                                    contact varchar(50),
                                    phone_number varchar(30),
                                    person_id uuid NOT NULL,
                                    FOREIGN KEY (person_id) REFERENCES person (id));

CREATE TABLE users
(id uuid PRIMARY KEY,
 username varchar(50),
 email varchar(50),
 password varchar(150),
 firstName varchar(15),
 lastName varchar(20));

CREATE TABLE authorities
(id uuid PRIMARY KEY,
 authority VARCHAR(25),
 user_id uuid,
 FOREIGN KEY (user_id) references users(id));

INSERT INTO users(id, username, email, password, firstName, lastName)
VALUES('20354d7a-e4fe-47af-8ff6-187bca92f3f9', 'admin', 'admin.admin@gmail.com',
       '{bcrypt}$2a$12$EyGaNhLqAr89nL89DWIAbu3mh6dSSKKlqfXXn/dw1FxZAS0nckhIi', 'admin', 'admin');


INSERT INTO authorities(id, authority, user_id)
VALUES('b5e2cf01-8bb6-4fcd-ad88-0efb611195da', 'admin',
       '20354d7a-e4fe-47af-8ff6-187bca92f3f9');


CREATE TABLE actualAddress (
                               id uuid PRIMARY KEY,
                               region varchar(80),
                               type_of_Locality varchar(50),
                               city varchar(30),
                               street varchar(10),
                               number_of_house varchar(10),
                               number_of_flat integer,
                               live_from date);


CREATE TABLE residentialAddress (
                                    id uuid PRIMARY KEY,
                                    region varchar(80),
                                    type_of_Locality varchar(50),
                                    city varchar(30),
                                    street varchar(10),
                                    number_of_house varchar(10),
                                    number_of_flat integer,
                                    live_from date);
