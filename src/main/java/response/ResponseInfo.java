package response;

import java.util.List;

/**
 * This class store data from json that we get after request
 * field Result store information about product
 */
public class ResponseInfo {

    private String contextId;

    private boolean success;

    private int code;

    private List<ProductInfo> results;

    private boolean finished;

    private int page;

    private int pageSize;

    private String postback;

    private String pin;

    public ResponseInfo() {}

    public List<ProductInfo> getResults() {
        return results;
    }

    public void setResults(List<ProductInfo> results) {
        this.results = results;
    }

    public String getContextId() {
        return contextId;
    }

    public void setContextId(String contextId) {
        this.contextId = contextId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getPostback() {
        return postback;
    }

    public void setPostback(String postback) {
        this.postback = postback;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
