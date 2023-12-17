/* If we want the SUM OF incomes AND expenses */
CREATE OR REPLACE FUNCTION get_income_and_expense_sum ( p_account_id INT, p_start_date TIMESTAMP, p_end_date TIMESTAMP) RETURNS DECIMAL AS $$
DECLARE
    v_sum DECIMAL;
BEGIN
    SELECT COALESCE(SUM(CASE WHEN transaction_type = 'Income' THEN amount ELSE 0 END), 0) -
           COALESCE(SUM(CASE WHEN transaction_type = 'Expense' THEN amount ELSE 0 END), 0)
    INTO v_sum
    FROM transaction
    WHERE account_id = p_account_id
      AND transaction_date BETWEEN p_start_date AND p_end_date;

    RETURN v_sum;
END;
$$;

/* If we want the sum of incomes AND the sum of expenses */
CREATE OR REPLACE FUNCTION somme_income_expense ( p_account_id INT, p_start_date TIMESTAMP, p_end_date TIMESTAMP) RETURNS TABLE (income_sum DECIMAL, expense_sum DECIMAL) AS $$
BEGIN
    RETURN QUERY
        SELECT
            COALESCE(SUM(CASE WHEN transaction_type = 'Income' THEN amount ELSE 0 END), 0) AS income_sum,
            COALESCE(SUM(CASE WHEN transaction_type = 'Expense' THEN amount ELSE 0 END), 0) AS expense_sum
        FROM transaction
        WHERE account_id = p_account_id
          AND transaction_date BETWEEN p_start_date AND p_end_date;
END;
$$;

