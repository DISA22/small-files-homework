import Contracts.BillLine;
import Contracts.CsvBillWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CsvBillWriterImpl implements CsvBillWriter {


    @Override
    public void writer(String path, ArrayList<BillLine> lines, BigDecimal total, int errors) throws IOException {
        try (FileWriter wr = new FileWriter("C:\\Users\\Динар\\IdeaProjects\\small-files-homework\\src\\Bill.CSV");) {
            for (BillLine line : lines) {
                wr.write(line.toString() + "\n");
            }
            wr.write("TOTAL" + total.toPlainString());
            wr.write("ERRORS" + errors);


        }
    }
}
