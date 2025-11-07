import Contracts.ProductLine;

import java.math.BigDecimal;

public class ProductLineImpl implements ProductLine {
    private String name;
    private int quantity;
    private BigDecimal price;

    public ProductLineImpl(String name, int quantity, BigDecimal price) {
        ParamsValidator.validateName(name);
        ParamsValidator.validatePrice(price);
        ParamsValidator.validateQiantity(quantity);

        this.name = name;
        this.quantity = quantity;
        this.price = price;
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
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductLineImpl{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public String toCsv() {
        return name + " " + quantity + " " + price + "\n";
    }
}


