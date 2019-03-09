package nc.opt.docubase.service.impl;

import nc.opt.docubase.configuration.DocubaseAutoConfiguration;
import nc.opt.docubase.service.DocubaseService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DocubaseAutoConfiguration.class)
public class DocubaseServiceTest {

    private static final String DOMAIN_URL = "https://docubasetest.intranet.opt/";

    @Autowired
    private DocubaseService docubaseService;

    @Test
    public void contextLoads() {
        Assert.assertNotNull(docubaseService.getUrlDomain());
        Assert.assertEquals(DOMAIN_URL, docubaseService.getUrlDomain());
    }

    @SpringBootApplication()
    static class TestConfiguration {
    }

}