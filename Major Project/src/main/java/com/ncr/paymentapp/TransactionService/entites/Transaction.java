package com.ncr.paymentapp.TransactionService.entites;
import com.ncr.paymentapp.TransactionService.models.TransactionStatus;
import com.ncr.paymentapp.TransactionService.models.TransactionType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String txId;
    private String fromUser;
    private String toUser;
    private Float amount;
    private TransactionType txType;
    private TransactionStatus status;
    @Temporal(value = TemporalType.DATE)
    private Date date;
}
