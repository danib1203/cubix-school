package hu.cubix.cubixschool.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "school")
@Component
@Getter
@Setter
public class SchoolConfigProperties {

    private String freeSemestersCron;

    private RetryConfig retry = new RetryConfig();

    @Getter
    @Setter
    public static class RetryConfig {
        private int maxAttempts;
        private long delayMs;
    }
}
