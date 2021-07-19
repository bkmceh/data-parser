public class Main {

    private final static int PRODUCT_COUNT = 100;
    private final static String CSV_SEPARATOR = ",";
    private final static String CSV_PATH = "./csv/products-data.csv";
    private final static String URL = "https://gpsfront.aliexpress.com/getRecommendingResults.do?widget_id=5547572&postback=acfff392-5ed4-4a90-a3a9-cd2b552630dd";

    public static void main(String[] args) {
        DataStorage dataStorage = new Grabber(URL).parse(PRODUCT_COUNT);
        CSVCreator.saveData(dataStorage, CSV_PATH, CSV_SEPARATOR);
    }
}
