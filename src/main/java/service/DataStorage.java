package service;

import java.util.List;
import java.util.ArrayList;
import domain.dto.ProductDTO;

/**
 * store information about products into List
 */
public class DataStorage {

    private List<ProductDTO> data;

    public List<ProductDTO> getData() {
        return data;
    }

    public DataStorage() {
        this.data = new ArrayList<>();
    }

    public void setData(List<ProductDTO> data) {
        this.data = data;
    }
}
