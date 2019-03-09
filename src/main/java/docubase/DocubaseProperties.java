package docubase;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("opt.docubase")
public class DocubaseProperties {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
