import Contracts.DiscountPolicy;
import Contracts.ReadResult;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class DiscountPolicyImpl implements DiscountPolicy {

    @Override
    public BigDecimal discountFor(BigDecimal subtotal, int quantity) {
        BigDecimal discount = null;
        if (quantity >= 3)
            discount = subtotal.multiply(new BigDecimal("0.1").setScale(2,RoundingMode.HALF_UP)); //размер скидки 10%

        return discount;
    }
}
