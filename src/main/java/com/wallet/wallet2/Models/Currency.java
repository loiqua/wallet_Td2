package com.wallet.wallet2.Models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Currency {
    private String currencyId;
    @NonNull
    private String name;
    @NonNull
    private String code;
}
