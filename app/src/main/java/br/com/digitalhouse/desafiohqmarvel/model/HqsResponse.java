package br.com.digitalhouse.desafiohqmarvel.model;

public class HqsResponse {

    @Expose
    private String attributionHTML;
    @Expose
    private String attributionText;
    @Expose
    private Long code;
    @Expose
    private String copyright;
    @Expose
    private String etag;
    @Expose
    private String status;

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public String getAttributionText() {
        return attributionText;
    }
    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public Long getCode() {
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }
    public String getCopyright() {
        return copyright;
    }
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
    public String getEtag() {
        return etag;
    }
    public void setEtag(String etag) {
        this.etag = etag;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
