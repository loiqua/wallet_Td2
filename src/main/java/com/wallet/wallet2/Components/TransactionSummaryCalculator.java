package com.wallet.wallet2.Components;

    import java.sql.*;
    import java.util.HashMap;
    import java.util.Map;
    import com.wallet.wallet2.connectionDB.*;

    public class TransactionSummaryCalculator {

        // Method to calculate the total amount between two dates for a specific account
        public static double getTotalAmountBetweenDates(int accountId, Date startDate, Date endDate) {
            double totalAmount = 0.0;
            Connection connection = ConnectionDB.getConnection();

            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT SUM(amount) AS total FROM transactions WHERE account_id = ? AND dateTime BETWEEN ? AND ?")) {

                preparedStatement.setInt(1, accountId);
                preparedStatement.setDate(2, startDate);
                preparedStatement.setDate(3, endDate);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    totalAmount = resultSet.getDouble("total");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return totalAmount;
        }
    }
