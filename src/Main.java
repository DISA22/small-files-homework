import Contracts.BillLine;
import Contracts.CsvProductReader;
import Contracts.ProductLine;
import Contracts.ReadResult;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BillService service = new BillService();


        service.processBilling();


    }
}