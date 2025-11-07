package Contracts;

import java.util.ArrayList;

public interface ReadResult<T> {
    ArrayList<ProductLine> getItems();
    int getErrorCount();
}
