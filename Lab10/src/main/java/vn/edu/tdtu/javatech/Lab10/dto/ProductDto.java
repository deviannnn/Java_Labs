package vn.edu.tdtu.javatech.Lab10.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Setter @Getter
public class ProductDto {

    private Long id;
    private String name;
    private Double price;

    private String brand;

    private String color;

    @Builder
    public ProductDto (long id, String name, double price, String brand, String color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.color = color;
    }

}