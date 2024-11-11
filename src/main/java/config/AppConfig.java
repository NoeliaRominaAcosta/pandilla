package config;

import mappers.FamilyMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public FamilyMapper familyMapper() {
        return new FamilyMapper();
    }
}
