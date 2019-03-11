package nc.opt.docubase.configuration;

import nc.opt.docubase.service.FactoryService;
import nc.opt.docubase.service.UserSessionService;
import nc.opt.docubase.service.impl.FactoryServiceImpl;
import nc.opt.docubase.service.impl.UserSessionServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConditionalOnProperty(value = "opt.docubase", havingValue = "")
public class DocubaseAutoConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "opt.docubase")
    public DocubaseProperties docubaseProperties() {
        return new DocubaseProperties();
    }

    // TODO mettre la declaration du  restTemplate directement dans les services FactoryService et UserSessionService
    @Bean(name = "docubaseRestTemplate")
    public RestOperations restTemplate(@Value("${opt.docubase.connect.timeout:2000}") String connectTimeout,
                                       @Value("${opt.docubase.read.timeout:2000}") String readTimeout) {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setReadTimeout(Integer.valueOf(readTimeout));
        clientHttpRequestFactory.setConnectTimeout(Integer.valueOf(connectTimeout));

        // false when dealing with big data in POST or PUT request
        clientHttpRequestFactory.setBufferRequestBody(false);

        return new RestTemplate(clientHttpRequestFactory);
    }

    @Bean
    public FactoryService factoryService(DocubaseProperties properties,
                                         @Qualifier("docubaseRestTemplate") RestOperations restTemplate) {
        return new FactoryServiceImpl(properties, restTemplate);
    }

    @Bean
    public UserSessionService docubaseService(DocubaseProperties properties,
                                              @Qualifier("docubaseRestTemplate") RestOperations restTemplate) {
        return new UserSessionServiceImpl(properties, restTemplate);
    }
}

