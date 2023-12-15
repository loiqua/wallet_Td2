package com.wallet.wallet2.Models;

import lombok.*;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Transaction {
        private String transactionId;
        @NonNull
        private String description;
        @NonNull
        private Double amount;
        @NonNull
        private LocalDateTime transactionDate;
        private String transactionType;
        @NonNull
        private String accountId;
}
