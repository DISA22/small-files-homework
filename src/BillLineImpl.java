import Contracts.BillLine;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BillLineImpl implements BillLine {
    private String name;
    private int quantity;
    private BigDecimal price;
    private boolean discountApplied;
    private BigDecimal finalTotal;

    public BillLineImpl(String name, int quantity, BigDecimal price, boolean discountApplied, BigDecimal finalTotal) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discountApplied = discountApplied;
        this.finalTotal = finalTotal;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public BigDecimal getUnitPrice() {
        if (isDiscountApplied()) {
            price = price.multiply(new BigDecimal("0.9")).setScale(2, RoundingMode.HALF_UP);
        }
        return price;
    }

    @Override
    public boolean isDiscountApplied() {
        return quantity >= 3;
    }

    @Override
    public BigDecimal getFinalTotal() {
        finalTotal = finalTotal.multiply(price).multiply(BigDecimal.valueOf(quantity));
        return finalTotal;
    }

    @Override
    public String toString() {
        return "BillLineImpl{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                "discountApplied" + discountApplied +
                ", finalTotal=" + finalTotal +
                '}';
    }
}
