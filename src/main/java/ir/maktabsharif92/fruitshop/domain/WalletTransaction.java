package ir.maktabsharif92.fruitshop.domain;

import ir.maktabsharif92.fruitshop.base.domain.BaseEntity;
import lombok.*;

import java.time.ZonedDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletTransaction extends BaseEntity<Long> {

    public static final String TABLE_NAME = "wallet_transaction";

    public static final String CUSTOMER_ID = "customer_id";
    public static final String WALLET_ID = "wallet_id";
    public static final String TOTAL_AMOUNT = "total_amount";
    public static final String CASH_AMOUNT = "cash_amount";
    public static final String CREDIT_AMOUNT = "credit_amount";
    public static final String TRANSACTION_TYPE = "TRANSACTION_TYPE";
    public static final String TOTAL_CHANGE = "TOTAL_CHANGE";
    public static final String CASH_CHANGE = "CASH_CHANGE";
    public static final String CREDIT_CHANGE = "CREDIT_CHANGE";
    public static final String CREATE_DATE = "CREATE_DATE";
    public static final String CODE = "CODE";
    public static final String TRANSACTION_PURPOSE = "TRANSACTION_PURPOSE";

    //    @Column(name = CUSTOMER_ID)
    private Long customerId;

    private Long walletId;

    private String transactionType;

    private Long totalChange;

    private Long cashChange;

    private Long creditChange;

    private Long totalAmount;

    private Long cashAmount;

    private Long creditAmount;

    private ZonedDateTime createDate;

    private String code;

    private String transactionPurpose;

}
