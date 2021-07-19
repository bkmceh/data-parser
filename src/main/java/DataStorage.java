import java.util.List;
import java.util.ArrayList;
import response.ProductInfo;


public class DataStorage {

    private List<ProductInfo> data;

    public List<ProductInfo> getData() {
        return data;
    }

    public DataStorage() {
        this.data = new ArrayList<>();
    }

    public void setData(List<ProductInfo> data) {
        this.data = data;
    }
}
