package nc.opt.docubase.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(JUnit4.class)
public class testUriComponentsBuilder {

    @Test
    public void testUriComponentsBuilder() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://google.com")
                .pathSegment("domain","5","base","5");

        builder.toUriString();
    }
}
