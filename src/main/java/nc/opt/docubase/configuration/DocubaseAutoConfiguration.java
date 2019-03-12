package nc.opt.docubase.configuration;

import nc.opt.docubase.service.FactoryService;
import nc.opt.docubase.service.UserSessionService;
import nc.opt.docubase.service.impl.FactoryServiceImpl;
import nc.opt.docubase.service.impl.UserSessionServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "opt.docubase", havingValue = "")
@ConditionalOnClass
public class DocubaseAutoConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "opt.docubase")
    public DocubaseProperties docubaseProperties() {
        return new DocubaseProperties();
    }

    @Bean
    public FactoryService factoryService(DocubaseProperties properties) {
        return new FactoryServiceImpl(properties);
    }

    @Bean
    public UserSessionService docubaseService(DocubaseProperties properties) {
        return new UserSessionServiceImpl(properties);
    }
}

