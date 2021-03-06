package nc.opt.docubase.service.impl;

import nc.opt.docubase.configuration.DocubaseAutoConfiguration;
import nc.opt.docubase.domain.builder.RequestBuilder;
import nc.opt.docubase.service.UserSessionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DocubaseAutoConfiguration.class)
public class UserSessionServiceTest {

    private static final String DOMAIN_URL = "https://docubasetest.intranet.opt/";

    @Autowired
    private UserSessionService userSessionService;

    @Test
    public void contextLoads() {
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.idDomain("123").idBase("456").idDocument("789");

    }

    @SpringBootApplication()
    static class TestConfiguration {
    }

}