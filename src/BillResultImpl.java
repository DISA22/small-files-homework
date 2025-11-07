import Contracts.BillLine;
import Contracts.BillResult;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BillResultImpl<T> implements BillResult {
    private ArrayList<T> lines;
    private BigDecimal allTotalPrice;

    public BillResultImpl(ArrayList<T> lines, BigDecimal allTotalPrice) {
        this.lines = lines;
        this.allTotalPrice = allTotalPrice;
    }

    @Override
    public ArrayList<T> getLines() {
        return lines;
    }

    @Override
    public BigDecimal getTotal() {
        return allTotalPrice;
    }
}
