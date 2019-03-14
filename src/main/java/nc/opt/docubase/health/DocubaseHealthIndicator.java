package nc.opt.docubase.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class DocubaseHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        return Health.up().withDetail("Docubase Status", "OK").build();
    }
}
