import java.util.List;

public class DataKeeper {

    private List<Product> data;

    public List<Product> getData() {
        return data;
    }

    public DataKeeper(final List<Product> data) {
        this.data = data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }
}
