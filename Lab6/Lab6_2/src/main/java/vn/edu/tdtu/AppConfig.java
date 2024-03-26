package vn.edu.tdtu;

import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {
    @Bean
    @Scope("singleton")
    public Product product1() {
        return new Product(1,"Iphone 14 Plus","made in US",2780);
    }

    @Bean
    @Scope("prototype")
    public Product product2() {
        return new Product(2,"MacBook Pro","made in US",4360);
    }

    @Bean
    @Scope
    public Product product3() {
        return new Product(3,"Samsung Galaxy Z-Flip","made in South Korea",2910);
    }
}

