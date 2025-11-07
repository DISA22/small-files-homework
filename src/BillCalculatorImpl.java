import Contracts.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class BillCalculatorImpl implements BillCalculator {
    private static DiscountPolicy discountPolicy = new DiscountPolicyImpl();

    @Override
    public BillResult<BillLine> calculate(ArrayList<ProductLine> items) {
        ArrayList<BillLineImpl> lines = new ArrayList<>();
        BigDecimal allTotalPrice = new BigDecimal("0");

        for (ProductLine item : items) {
            BigDecimal subtotal = item.getUnitPrice().multiply(new BigDecimal(item.getQuantity()));
            BigDecimal discount = discountPolicy.discountFor(subtotal, item.getQuantity());
            BigDecimal finalTotal = subtotal.subtract(discount).setScale(2, RoundingMode.HALF_UP);
            allTotalPrice = allTotalPrice.add(finalTotal);
            lines.add((BillLineImpl) item);
        }


        return new BillResultImpl<>(lines, allTotalPrice);

    }
}
