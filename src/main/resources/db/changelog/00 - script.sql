-- drop database coinmarket;
-- create database coinmarket;

\c coinmarket;


drop table if exists conversions;
drop sequence if exists conversions_id_seq;
create sequence conversions_id_seq;

CREATE TABLE conversions
(
    id         INT PRIMARY KEY DEFAULT nextval('conversions_id_seq'),
    request_id TEXT             NOT NULL UNIQUE,
    symbol     TEXT             NOT NULL,
    amount     DOUBLE PRECISION NOT NULL,
    currency   TEXT             NOT NULL,
    result     DOUBLE PRECISION NOT NULL,
    created_at TIMESTAMP       DEFAULT NOW(),
    updated_at TIMESTAMP       DEFAULT NOW()
);

CREATE INDEX symbol_index ON conversions (symbol);
