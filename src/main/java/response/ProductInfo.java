package response;

public class ProductInfo {

    private long productId;

    private long sellerId;

    private String oriMinPrice;

    private String oriMaxPrice;

    private long promotionId;

    private long startTime;

    private long endTime;

    private long phase;

    private String productTitle;

    private String minPrice;

    private String maxPrice;

    private String discount;

    private String orders;

    private String productImage;

    private String productDetailUrl;

    private String shopUrl;

    private String trace;

    private String totalTranpro3;

    private String productPositiveRate;

    private String productAverageStar;

    private long itemEvalTotalNum;

    public ProductInfo() {}

    public Long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public String getOriMinPrice() {
        return oriMinPrice;
    }

    public void setOriMinPrice(String oriMinPrice) {
        this.oriMinPrice = oriMinPrice;
    }

    public String getOriMaxPrice() {
        return oriMaxPrice;
    }

    public void setOriMaxPrice(String oriMaxPrice) {
        this.oriMaxPrice = oriMaxPrice;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(long promotionId) {
        this.promotionId = promotionId;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Long getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDetailUrl() {
        return productDetailUrl;
    }

    public void setProductDetailUrl(String productDetailUrl) {
        this.productDetailUrl = productDetailUrl;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public String getTotalTranpro3() {
        return totalTranpro3;
    }

    public void setTotalTranpro3(String totalTranpro3) {
        this.totalTranpro3 = totalTranpro3;
    }

    public String getProductPositiveRate() {
        return productPositiveRate;
    }

    public void setProductPositiveRate(String productPositiveRate) {
        this.productPositiveRate = productPositiveRate;
    }

    public String getProductAverageStar() {
        return productAverageStar;
    }

    public void setProductAverageStar(String productAverageStar) {
        this.productAverageStar = productAverageStar;
    }

    public Long getItemEvalTotalNum() {
        return itemEvalTotalNum;
    }

    public void setItemEvalTotalNum(int itemEvalTotalNum) {
        this.itemEvalTotalNum = itemEvalTotalNum;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", sellerId=" + sellerId +
                ", oriMinPrice='" + oriMinPrice + '\'' +
                ", oriMaxPrice='" + oriMaxPrice + '\'' +
                ", promotionId=" + promotionId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", phase=" + phase +
                ", productTitle='" + productTitle + '\'' +
                ", minPrice='" + minPrice + '\'' +
                ", maxPrice='" + maxPrice + '\'' +
                ", discount='" + discount + '\'' +
                ", orders='" + orders + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productDetailUrl='" + productDetailUrl + '\'' +
                ", shopUrl='" + shopUrl + '\'' +
                ", trace='" + trace + '\'' +
                ", totalTranpro3='" + totalTranpro3 + '\'' +
                ", productPositiveRate='" + productPositiveRate + '\'' +
                ", productAverageStar='" + productAverageStar + '\'' +
                ", itemEvalTotalNum=" + itemEvalTotalNum +
                '}';
    }
}
