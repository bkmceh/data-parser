public class Main {

    private final static String URL = "https://gpsfront.aliexpress.com/getRecommendingResults.do" +
            "?widget_id=5547572" +
            "&limit=10" +
            "&postback=acfff392-5ed4-4a90-a3a9-cd2b552630dd" +
            "&offset=";

    public static void main(String[] args) {

        DataKeeper dataKeeper = new Scratch(URL).parse();
        System.out.println(dataKeeper.getData().get(0).toString());

    }
}
