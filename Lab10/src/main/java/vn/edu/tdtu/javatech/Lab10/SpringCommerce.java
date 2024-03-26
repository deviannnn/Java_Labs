package vn.edu.tdtu.javatech.Lab10;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.tdtu.javatech.Lab10.model.Product;
import vn.edu.tdtu.javatech.Lab10.service.OrderProductService;
import vn.edu.tdtu.javatech.Lab10.service.OrderService;
import vn.edu.tdtu.javatech.Lab10.service.ProductService;

@SpringBootApplication
public class SpringCommerce {

	@Bean
	CommandLineRunner runner(ProductService productService, OrderService orderService, OrderProductService orderProductService) {
		return args -> {
			productService.save(new Product(1L, "TV Set", 300.00,  "SamSung", "black"));
			productService.save(new Product(2L, "Game Console", 200.00, "MS", "black"));
			productService.save(new Product(3L, "Sofa", 100.00, "IKEA", "brown"));
			productService.save(new Product(4L, "Icecream", 5.00, "Walls", "pink"));
			productService.save(new Product(5L, "Beer", 3.00, "Tiger", "brown"));
			productService.save(new Product(6L, "Phone", 500.00, "Apple", "white"));
			productService.save(new Product(7L, "Watch", 30.00, "Rolex", "black"));
			productService.save(new Product(8L, "Laptop", 2000.00, "Apple", "white"));
			productService.save(new Product(9L, "Shirt", 30.00, "Banan Republic", "red"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCommerce.class, args);
	}

}
