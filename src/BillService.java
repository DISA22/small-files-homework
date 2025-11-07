import Contracts.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class BillService {
    public void processBilling() {
        CsvProductReaderImpl reader = new CsvProductReaderImpl();
        BillCalculatorImpl calculator = new BillCalculatorImpl();
        CsvBillWriterImpl writer = new CsvBillWriterImpl();
        try {
            ReadResult<ProductLine> resultReader = reader.read("C:\\Users\\Динар\\IdeaProjects\\small-files-homework\\src\\Product.CSV");
            BillResult<BillLine> resultCalculate = calculator.calculate((ArrayList<ProductLine>) resultReader);
            ArrayList<BillLine> list = resultCalculate.getLines();
            BigDecimal totalPrice = resultCalculate.getTotal();
            int errors = resultReader.getErrorCount();
            writer.writer("C:\\Users\\Динар\\IdeaProjects\\small-files-homework\\src\\Bill.CSV", list, totalPrice, errors);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
