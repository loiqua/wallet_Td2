-- Insertion de devises

INSERT INTO currency (name, code)
VALUES ('Euro',
        'EUR'), ('Dollar',
                 'USD'), ('Yen',
                          'JPY');

-- Insertion de comptes

INSERT INTO account (name, current_amount, account_type, account_number, currency_id)
VALUES ('Compte Courant',
        5000,
        'Checking',
        '123456789',
        1), ('Compte Épargne',
             10000,
             'Savings',
             '987654321',
             2);

-- Insertion d'étiquettes de transaction

INSERT INTO transaction_tag (name)
VALUES ('Foods'), ('Electronics'), ('Salaries');

-- Insertion de catégories de transaction

INSERT INTO transaction_category (name)
VALUES ('Groceries'), ('Electronics'), ('Salary');

-- Insertion de transactions

INSERT INTO transaction (tag_id,
                         category_id,
                         amount,
                         transaction_type,
                         transfer_to,
                         account_id)
VALUES (1,
        1,
        50,
        'Spending',
        NULL,
        1), (2,
             2,
             100,
             'Spending',
             NULL,
             1), (3,
                  3,
                  2000,
                  'Income',
                  NULL,
                  2);

-- Insertion d'historique de transfert

INSERT INTO transfer_history (debit_transaction_id, credit_transaction_id)
VALUES (1,
        2);

-- Insertion de la valeur des devises

INSERT INTO currency_value (source_currency_id, destination_currency_id, change_rate)
VALUES (1,
        2,
        1.2), (1,
               3,
               129.5), (2,
                        1,
                        0.8), (2,
                               3,
                               109.5), (3,
                                        1,
                                        0.0077), (3,
                                                  2,
                                                  0.0091);

