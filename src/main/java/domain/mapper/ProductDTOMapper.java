package domain.mapper;

import domain.dto.ProductDTO;

import java.util.List;
import java.util.ArrayList;

/**
 * this class convert data
 */
public class ProductDTOMapper {

    private final List<ProductDTO> data;

    public ProductDTOMapper(List<ProductDTO> data) {
        this.data = data;
    }

    /**
     * convert List<ProductDTO> into List<List<String>> for further work with it
     * @return {@code List<List<String>>} for comfortable work with data
     */
    public List<List<String>> toEntity() {
        List<List<String>> products = new ArrayList<>();
        for (ProductDTO product : data) {
            List<String> productFields = new ArrayList<>();
            productFields.add(product.getProductId().toString());
            productFields.add(product.getSellerId().toString());
            productFields.add(product.getOriMinPrice());
            productFields.add(product.getOriMaxPrice());
            productFields.add(product.getPromotionId().toString());
            productFields.add(product.getStartTime().toString());
            productFields.add(product.getEndTime().toString());
            productFields.add(product.getPhase().toString());
            productFields.add(product.getProductTitle());
            productFields.add(product.getMinPrice());
            productFields.add(product.getMaxPrice());
            productFields.add(product.getDiscount());
            productFields.add(product.getOrders());
            productFields.add(product.getProductImage());
            productFields.add(product.getProductDetailUrl());
            productFields.add(product.getShopUrl());
            productFields.add(product.getTrace());
            productFields.add(product.getTotalTranpro3());
            productFields.add(product.getProductPositiveRate());
            productFields.add(product.getProductAverageStar());
            productFields.add(product.getItemEvalTotalNum().toString());
            products.add(productFields);
        }
        return products;
    }
}
