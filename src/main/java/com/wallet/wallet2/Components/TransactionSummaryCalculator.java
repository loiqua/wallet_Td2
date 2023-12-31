package com.wallet.wallet2.Components;

    import java.sql.*;
    import java.util.HashMap;
    import java.util.Map;
    import com.wallet.wallet2.connectionDB.*;

    public class TransactionSummaryCalculator {

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

        public static Map<String, Double> getCategoryAmountsBetweenDates(int accountId, Date startDate, Date endDate) {
            Map<String, Double> categoryAmounts = new HashMap<>();
            Connection connection = ConnectionDB.getConnection();

            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT COALESCE(c.category_name, 'No category') AS category, SUM(t.amount) AS total " +
                            "FROM transactions t LEFT JOIN categories c ON t.category = c.category_name " +
                            "WHERE t.account_id = ? AND t.dateTime BETWEEN ? AND ? " +
                            "GROUP BY c.category_name")) {

                preparedStatement.setInt(1, accountId);
                preparedStatement.setDate(2, startDate);
                preparedStatement.setDate(3, endDate);

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String category = resultSet.getString("category");
                    double amount = resultSet.getDouble("total");
                    categoryAmounts.put(category, amount);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return categoryAmounts;
        }

        public static void main(String[] args) {
            int accountId = 1; 
            Date startDate = Date.valueOf("2023-12-01");
            Date endDate = Date.valueOf("2023-12-02");

            double totalAmount = getTotalAmountBetweenDates(accountId, startDate, endDate);
            System.out.println("Total amount between dates: " + totalAmount);

            Map<String, Double> categoryAmounts = getCategoryAmountsBetweenDates(accountId, startDate, endDate);
            for (Map.Entry<String, Double> entry : categoryAmounts.entrySet()) {
                System.out.println("Category: " + entry.getKey() + ", Amount: " + entry.getValue());
            }
            ConnectionDB.closeConnection();
        }
    }
