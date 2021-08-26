package domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * This class store data from json that we get after request
 * field Results store information about product
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InformationDTO {

    private List<ProductDTO> results;

    public InformationDTO() {}

    public List<ProductDTO> getResults() {
        return results;
    }

    public void setResults(List<ProductDTO> results) {
        this.results = results;
    }
}
