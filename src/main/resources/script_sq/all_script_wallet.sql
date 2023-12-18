-- Création de la base de données s'il n'existe pas déjà
CREATE DATABASE IF NOT EXISTS wallet_2;

-- Sélection de la base de données
\c wallet2;

-- Création de la table currency
CREATE TABLE IF NOT EXISTS currency (
                                        currency_id BIGSERIAL PRIMARY KEY,
                                        name VARCHAR(100) NOT NULL,
    code VARCHAR(255) NOT NULL UNIQUE
    );

-- Création de la table account
CREATE TABLE IF NOT EXISTS account (
                                       account_id BIGSERIAL PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
    current_amount DOUBLE PRECISION DEFAULT 0,
    account_type VARCHAR(255) NOT NULL,
    account_number VARCHAR,
    currency_id BIGINT REFERENCES currency(currency_id) ON DELETE CASCADE NOT NULL,
    creation_timestamp TIMESTAMP DEFAULT NOW()
    );

-- Création de la table balance
CREATE TABLE IF NOT EXISTS balance (
                                       balance_id BIGSERIAL PRIMARY KEY,
                                       balance_timestamp TIMESTAMP NOT NULL,
                                       account_id BIGINT REFERENCES account(account_id) ON DELETE CASCADE NOT NULL,
    amount DOUBLE PRECISION NOT NULL
    );

-- Création de la table transaction_tag
CREATE TABLE IF NOT EXISTS transaction_tag (
                                               tag_id SERIAL PRIMARY KEY,
                                               name TEXT UNIQUE NOT NULL
);

-- Création de la table transaction_category
CREATE TABLE IF NOT EXISTS transaction_category (
                                                    category_id SERIAL PRIMARY KEY,
                                                    name TEXT UNIQUE NOT NULL
);

-- Création de la table transaction
CREATE TABLE IF NOT EXISTS transaction (
                                           transaction_id BIGSERIAL PRIMARY KEY,
                                           tag_id INT REFERENCES transaction_tag(tag_id) ON DELETE CASCADE NOT NULL,
    category_id INT REFERENCES transaction_category(category_id) ON DELETE SET NULL,
    amount DOUBLE PRECISION DEFAULT 0,
    transaction_type VARCHAR(255) NOT NULL,
    transfer_to BIGINT REFERENCES transaction(transaction_id) ON DELETE CASCADE,
    account_id BIGINT REFERENCES account(account_id) ON DELETE CASCADE,
    creation_timestamp TIMESTAMP DEFAULT NOW()
    );

-- Création de la table transfer_history
CREATE TABLE IF NOT EXISTS transfer_history (
                                                transfer_history_id BIGSERIAL PRIMARY KEY,
                                                debit_transaction_id BIGINT REFERENCES transaction(transaction_id) ON DELETE CASCADE,
    credit_transaction_id BIGINT REFERENCES transaction(transaction_id) ON DELETE CASCADE,
    transfer_date TIMESTAMP DEFAULT NOW()
    );

-- Création de la table currency_value
CREATE TABLE IF NOT EXISTS currency_value (
                                              currency_value_id BIGSERIAL PRIMARY KEY,
                                              source_currency_id BIGINT REFERENCES currency(currency_id) ON DELETE CASCADE NOT NULL,
    destination_currency_id BIGINT REFERENCES currency(currency_id) ON DELETE CASCADE NOT NULL,
    change_rate DOUBLE PRECISION DEFAULT 0,
    currency_value_date TIMESTAMP DEFAULT NOW()
    );

                                                                                                                                                                                                         change_rate DOUBLE PRECISION DEFAULT 0,
                                                                                                                                                                                                                                              currency_value_date TIMESTAMP DEFAULT NOW());

