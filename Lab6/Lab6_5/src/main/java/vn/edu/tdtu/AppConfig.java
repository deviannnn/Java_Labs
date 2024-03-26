package vn.edu.tdtu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
    @PropertySource("classpath:app.properties")
})
public class AppConfig {
    @Bean
    public Product product() {
        return new Product();
    }
}

