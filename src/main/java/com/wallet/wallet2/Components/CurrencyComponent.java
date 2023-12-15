package com.wallet.wallet2.Components;

import lombok.*;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class CurrencyComponent {
    private String currencyId;
    private String name;
    private String code;
}
