import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import response.ProductInfo;
import response.ResponseInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Grabber {

    private final String url;
    private static final int LIMIT = 10;
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final List<ProductInfo> PRODUCTS = new ArrayList<>();
    private static final DataStorage DATA_STORAGE = new DataStorage();
    private static final String RUSSIAN_REGION_COOKIE = "aep_usuc_f=region=RU&site=rus&b_locale=ru_RU&c_tp=RUB";

    public Grabber(final String url) {
        this.url = url + String.format("&limit=%s&offset=", LIMIT);
    }

    public DataStorage parse(final int PRODUCT_COUNT) {
        ResponseInfo info = new ResponseInfo();
        int page = 0;
        while (PRODUCTS.size() < PRODUCT_COUNT) {
            int OFFSET = page * LIMIT;
            try(CloseableHttpClient client = HttpClients.createDefault()) {
                CloseableHttpResponse response = client.execute(createRequest(OFFSET));
                final int statusCode = response.getStatusLine().getStatusCode();
                if (HttpStatus.SC_OK != statusCode) {
                    throw new ParseException("Can not get response");
                }
                String jsonResponse = EntityUtils.toString(response.getEntity());
                info = MAPPER.readValue(jsonResponse, ResponseInfo.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PRODUCTS.addAll(info.getResults());
            page++;
        }
        DATA_STORAGE.setData(PRODUCTS);
        return DATA_STORAGE;
    }

    private HttpUriRequest createRequest(final int offset) {
        final HttpGet request = new HttpGet(url + offset);
        request.setHeader("Cookie", RUSSIAN_REGION_COOKIE);
        return request;
    }
}
