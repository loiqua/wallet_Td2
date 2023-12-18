-- Inserting data into the currency table
INSERT INTO currency (name, code) VALUES
                                      ('US Dollar', 'USD'),
                                      ('Euro', 'EUR'),
                                      ('British Pound', 'GBP');

-- Inserting data into the account table
INSERT INTO account (name, current_amount, account_type, account_number, currency_id) VALUES
                                                                                          ('Savings Account', 5000.00, 'Savings', '123456789', 1),
                                                                                          ('Checking Account', 1500.00, 'Checking', '987654321', 2);

-- Inserting data into the balance table
INSERT INTO balance (balance_timestamp, account_id, amount) VALUES
                                                                (CURRENT_TIMESTAMP, 1, 5000.00),
                                                                (CURRENT_TIMESTAMP, 2, 1500.00);

-- Inserting data into the transaction_tag table
INSERT INTO transaction_tag (name) VALUES
                                       ('Groceries'),
                                       ('Utilities'),
                                       ('Entertainment');

-- Inserting data into the transaction_category table
INSERT INTO transaction_category (name) VALUES
                                            ('Income'),
                                            ('Expense');

-- Inserting data into the transaction table
INSERT INTO transaction (tag_id, category_id, amount, transaction_type, transfer_to, account_id) VALUES
                                                                                                     (1, 2, 50.00, 'Expense', NULL, 1),
                                                                                                     (2, 1, 2000.00, 'Income', NULL, 2),
                                                                                                     (3, NULL, 100.00, 'Expense', NULL, 1);

-- Inserting data into the transfer_history table
INSERT INTO transfer_history (debit_transaction_id, credit_transaction_id, transfer_date) VALUES
                                                                                              (1, 2, CURRENT_TIMESTAMP),
                                                                                              (3, NULL, CURRENT_TIMESTAMP);

-- Inserting data into the currency_value table
INSERT INTO currency_value (source_currency_id, destination_currency_id, change_rate, currency_value_date) VALUES
                                                                                                               (1, 2, 0.85, CURRENT_TIMESTAMP),
                                                                                                               (2, 1, 1.18, CURRENT_TIMESTAMP);

