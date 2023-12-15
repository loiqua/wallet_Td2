package com.wallet.wallet2.Components;

import lombok.*;


import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class AccountComponent {
    private String accountId;
    private String name;
    private BalanceComponent balance;
    private CurrencyComponent currency;
    private List<TransactionComponent> transactionList;
    private String accountType;
}
