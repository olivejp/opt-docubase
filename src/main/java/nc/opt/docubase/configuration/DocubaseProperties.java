package nc.opt.docubase.configuration;

public class DocubaseProperties {

    private String profile;
    private String password;
    private String host;
    private String restApiSegment;
    private String connectionTimeout;
    private String readTimeout;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getRestApiSegment() {
        return restApiSegment;
    }

    public void setRestApiSegment(String restApiSegment) {
        this.restApiSegment = restApiSegment;
    }

    public String getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(String connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public String getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(String readTimeout) {
        this.readTimeout = readTimeout;
    }
}
