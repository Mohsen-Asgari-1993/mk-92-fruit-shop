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

    private Long customerId;

    private Long totalAmount;

    private Long cashAmount;

    private Long creditAmount;

}
