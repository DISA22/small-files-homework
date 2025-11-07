import Contracts.CsvProductReader;
import Contracts.ProductLine;
import Contracts.ReadResult;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class CsvProductReaderImpl implements CsvProductReader {
    @Override
    public ReadResult<ProductLine> read(String path) throws IOException {
        ArrayList<ProductLine> list = new ArrayList<>();
        int errorCount = 0;

        List<String> lines = null;
        try {
            lines = Files.readAllLines(Path.of("C:\\Users\\Динар\\IdeaProjects\\small-files-homework\\src\\Product.CSV"));
        } catch (IOException exception) {
            System.out.println("Что-то пошло не так при чтении файла: " + exception.getMessage());

        }

        lines = lines.subList(1, lines.size());

        for (String line : lines) {
            if (line.startsWith("#")) errorCount++;
            String[] parts = line.trim().split(";");

            ProductLineImpl item = new ProductLineImpl(
                    parts[0],
                    Integer.parseInt(parts[1]),
                    new BigDecimal(parts[2])
            );
            list.add(item);
        }

        return new ReadResultImpl<>(list, errorCount);

    }

}
