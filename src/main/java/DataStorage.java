import response.ProductInfo;

import java.util.ArrayList;
import java.util.List;

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
