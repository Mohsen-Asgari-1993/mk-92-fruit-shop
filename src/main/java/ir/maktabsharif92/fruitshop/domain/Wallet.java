package ir.maktabsharif92.fruitshop.domain;

import ir.maktabsharif92.fruitshop.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Wallet extends BaseEntity<Long> {

    public static final String TABLE_NAME = "wallet";

    public static final String CUSTOMER_ID = "customer_id";
    public static final String TOTAL_AMOUNT = "total_amount";
    public static final String CASH_AMOUNT = "cash_amount";
    public static final String CREDIT_AMOUNT = "credit_amount";

    //    @Column(name = CUSTOMER_ID)
    private Long customerId;

    //    @Column(name = TOTAL_AMOUNT)
    private Long totalAmount;

    //    @Column(name = CASH_AMOUNT)
    private Long cashAmount;

    //    @Column(name = CREDIT_AMOUNT)
    private Long creditAmount;

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + getId() +
                ", customerId=" + customerId +
                ", totalAmount=" + totalAmount +
                ", cashAmount=" + cashAmount +
                ", creditAmount=" + creditAmount +
                '}';
    }
}
