CREATE DATABASE wallet;

CREATE TABLE IF NOT EXISTS currency (
                                        id BIGSERIAL PRIMARY KEY,
                                        name VARCHAR(100) NOT NULL,
    country TEXT NOT NULL UNIQUE
    );

CREATE TABLE IF NOT EXISTS account (
                                       id BIGSERIAL PRIMARY KEY,
                                       name VARCHAR(255),
    current_amount DOUBLE PRECISION DEFAULT 0,
    type VARCHAR(255),
    account_number VARCHAR,
    currency_id BIGINT REFERENCES currency(id) ON DELETE CASCADE NOT NULL,
    creation_timestamp TIMESTAMP DEFAULT NOW()
    );

CREATE TABLE IF NOT EXISTS account_amount (
                                              id BIGSERIAL PRIMARY KEY,
                                              amount DOUBLE PRECISION,
                                              account_id BIGINT REFERENCES account(id) ON DELETE CASCADE,
    transaction_time TIMESTAMP DEFAULT NOW()
    );

CREATE TABLE IF NOT EXISTS transaction_tag (
                                               id SERIAL PRIMARY KEY,
                                               name TEXT UNIQUE
);

CREATE TABLE IF NOT EXISTS transaction_category (
                                                    id SERIAL PRIMARY KEY,
                                                    name TEXT UNIQUE
);

CREATE TABLE IF NOT EXISTS transaction (
                                           id BIGSERIAL PRIMARY KEY,
                                           tag_id INT REFERENCES transaction_tag(id) ON DELETE CASCADE NOT NULL,
    category_id INT REFERENCES transaction_category(id) ON DELETE SET NULL,
    amount DOUBLE PRECISION DEFAULT 0,
    type VARCHAR(255) NOT NULL, -- Assuming 'VARCHAR(255)' as the transaction_type
    transfer_to BIGINT REFERENCES transaction(id) ON DELETE CASCADE,
    account_id BIGINT REFERENCES account(id) ON DELETE CASCADE,
    creation_timestamp TIMESTAMP DEFAULT NOW()
    );

CREATE TABLE IF NOT EXISTS transfer_history (
                                                id BIGSERIAL PRIMARY KEY,
                                                transfer_from BIGINT REFERENCES transaction(id) ON DELETE CASCADE,
    transfer_to BIGINT REFERENCES transaction(id) ON DELETE CASCADE,
    transfer_time TIMESTAMP DEFAULT NOW()
    );

CREATE TABLE IF NOT EXISTS currency_value (
                                              id BIGSERIAL PRIMARY KEY,
                                              source_currency_id BIGINT REFERENCES currency(id) ON DELETE CASCADE NOT NULL,
    destination_currency_id BIGINT REFERENCES currency(id) ON DELETE CASCADE NOT NULL,
    amount DOUBLE PRECISION DEFAULT 0,
    effect_date TIMESTAMP DEFAULT NOW()
    );


