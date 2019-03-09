package nc.opt.docubase.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "opt.docubase", ignoreUnknownFields = false)
public class DocubaseProperties {

    private boolean enabled;
    private String url;
    private String urlUserSession;
    private String urlFactory;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlUserSession() {
        return urlUserSession;
    }

    public void setUrlUserSession(String urlUserSession) {
        this.urlUserSession = urlUserSession;
    }

    public String getUrlFactory() {
        return urlFactory;
    }

    public void setUrlFactory(String urlFactory) {
        this.urlFactory = urlFactory;
    }
}
