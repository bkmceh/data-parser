package service;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import domain.dto.ProductDTO;
import domain.dto.InformationDTO;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;


public class Grabber {

    private final String url;
    private static final int LIMIT = 10;
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final List<ProductDTO> PRODUCTS = new ArrayList<>();
    private static final DataStorage DATA_STORAGE = new DataStorage();
    private static final String RUSSIAN_REGION_COOKIE = "aep_usuc_f=region=RU&site=rus&b_locale=ru_RU&c_tp=RUB";

    public Grabber(final String url) {
        this.url = url + String.format("&limit=%s&offset=", LIMIT);
    }

    /**
     * parse the site and get data about products
     * @param PRODUCT_COUNT store the count of products
     * @return {@code utils.DataStorage} that store information from json domain.response
     */
    public DataStorage parse(final int PRODUCT_COUNT) {
        InformationDTO info = new InformationDTO();
        int page = 0;
        while (PRODUCTS.size() < PRODUCT_COUNT) {
            int OFFSET = page * LIMIT;
            try(CloseableHttpClient client = HttpClients.createDefault()) {
                CloseableHttpResponse response = client.execute(createRequest(OFFSET));
                final int statusCode = response.getStatusLine().getStatusCode();
                if (HttpStatus.SC_OK != statusCode) {
                    throw new ParseException("Unable to get domain.response");
                }
                String jsonResponse = EntityUtils.toString(response.getEntity());
                info = MAPPER.readValue(jsonResponse, InformationDTO.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PRODUCTS.addAll(info.getResults());
            page++;
        }
        DATA_STORAGE.setData(PRODUCTS);
        return DATA_STORAGE;
    }

    /**
     * create the GET request
     * @param offset store how many string with information need to miss,
     *               like number of page with products
     * @return {@code HttpUriRequest}
     */
    private HttpUriRequest createRequest(final int offset) {
        final HttpGet request = new HttpGet(url + offset);
        request.setHeader("Cookie", RUSSIAN_REGION_COOKIE);
        return request;
    }
}
