package nc.opt.docubase.configuration;

import nc.opt.docubase.service.FactoryService;
import nc.opt.docubase.service.UserSessionService;
import nc.opt.docubase.service.impl.FactoryServiceImpl;
import nc.opt.docubase.service.impl.UserSessionServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConditionalOnProperty(prefix = "opt.docubase")
@EnableConfigurationProperties({DocubaseProperties.class})
public class DocubaseAutoConfiguration {

    private DocubaseProperties properties;

    public DocubaseAutoConfiguration(DocubaseProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnProperty(prefix = "opt.docubase", value = {"connect.timeout", "read.timeout"})
    public ClientHttpRequestFactory createClientHttpFactory(@Value("opt.docubase.connect.timeout") int connectTimeout,
                                                            @Value("opt.docubase.read.timeout") int readTimeout) {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setReadTimeout(readTimeout);
        clientHttpRequestFactory.setConnectTimeout(connectTimeout);

        // false when dealing with big data in POST or PUT request
        clientHttpRequestFactory.setBufferRequestBody(false);
        return clientHttpRequestFactory;
    }

    @Bean(name = "docubaseRestTemplate")
    public RestOperations restTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
        return new RestTemplate(clientHttpRequestFactory);
    }

    @Bean
    public FactoryService factoryService() {
        return new FactoryServiceImpl(properties);
    }

    @Bean
    public UserSessionService docubaseService() {
        return new UserSessionServiceImpl(properties);
    }
}

