import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Scratch {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String RUSSIAN = "aep_usuc_f=region=RU&site=rus&b_locale=ru_RU&c_tp=RUB";

    private final String url;

    private final String offset = "0";

    public Scratch(final String url) {
        this.url = url;
    }

    public DataKeeper parse() {
        ProductList list = new ProductList();
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            CloseableHttpResponse response = client.execute(createRequest());
            final int statusCode = response.getStatusLine().getStatusCode();
            if (HttpStatus.SC_OK != statusCode) {
                throw new ParseException("Can not get response");
            }
            String jsonResponse = EntityUtils.toString(response.getEntity());
            list = MAPPER.readValue(jsonResponse, ProductList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DataKeeper(list.getResults());
    }

    private HttpUriRequest createRequest() {
        String urlWithOffset = url + offset;
        final HttpGet request = new HttpGet(urlWithOffset);
        request.setHeader("Cookie", RUSSIAN);
        return request;
    }
}
