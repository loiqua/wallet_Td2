package com.wallet.wallet2.Components;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionSummaryCalculatorNoUseSQL {

    public static double getTotalAmountBetweenDates(String accountId, LocalDateTime startDate, LocalDateTime endDate) {
        TransactionCrudOperations crudOperations = new TransactionCrudOperations();

        List<TransactionComponent> transactions = crudOperations.getTransactionByAccountId(accountId);

        double totalAmount = 0.0;
        for (TransactionComponent transaction : transactions) {
            LocalDateTime transactionDate = transaction.getTransactionDate();
            if (transactionDate.isAfter(startDate) && transactionDate.isBefore(endDate)) {
                if ("income".equals(transaction.getTransactionType())) {
                    totalAmount += transaction.getAmount();
                } else if ("expense".equals(transaction.getTransactionType())) {
                    totalAmount -= transaction.getAmount();
                }
            }
        }

        return totalAmount;
    }
}
