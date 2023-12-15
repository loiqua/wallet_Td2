package com.wallet.wallet2.Components;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class BalanceComponent {
    private Double amount;
    private LocalDateTime lastUpdate;
}
