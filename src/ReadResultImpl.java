import Contracts.ProductLine;
import Contracts.ReadResult;
import java.util.ArrayList;


public class ReadResultImpl<T> implements ReadResult<T> {
    private ArrayList<ProductLine> items;
    private int errorCount;

    public ReadResultImpl(ArrayList<ProductLine> items, int errorCount) {
        this.items = items;
        this.errorCount = errorCount;
    }

    @Override
    public ArrayList<ProductLine> getItems() {
       return items;
    }

    @Override
    public int getErrorCount() {
        return errorCount;
    }

}
