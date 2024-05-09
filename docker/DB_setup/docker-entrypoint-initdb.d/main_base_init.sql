CREATE TYPE currency AS ENUM ('USD', 'EUR', 'RUB', 'BYN');

CREATE TYPE time_period AS ENUM ('YEAR', 'QUARTER', 'MONTH', 'DAY', 'HOUR');

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username varchar(20) NOT NULL,
    password varchar(40) NOT NULL
);

CREATE TABLE account (
    account_id SERIAL PRIMARY KEY,
    account_name text, 
    user_id integer UNIQUE CONSTRAINT FK_users REFERENCES users ON DELETE CASCADE,
    last_seen timestamp,
    note varchar(20000)
);

CREATE TABLE saving (
    saving_id SERIAL PRIMARY KEY ,
    amount bigint NOT NULL,
    currency currency NOT NULL,
    interest bigint NOT NULL,
    deposit boolean NOT NULL,
    capitalization boolean NOT NULL,
    account_id integer CONSTRAINT FK_account REFERENCES account ON DELETE CASCADE   
);

CREATE TABLE item (
    item_id SERIAL PRIMARY KEY ,
    title varchar(20) NOT NULL,
    amount bigint NOT NULL,
    currency currency NOT NULL,
    time_period time_period NOT NULL,
    icon varchar(40) NOT NULL,
    account_id integer CONSTRAINT FK_account REFERENCES account ON DELETE CASCADE 
);    
    