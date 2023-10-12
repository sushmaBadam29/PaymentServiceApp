package com.project.paymentapp.WalletService.Entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WalletResponse {
    private String txId;
    private WalletStatus success;
}
