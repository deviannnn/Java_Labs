package vn.edu.tdtu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Product p1 = context.getBean("product1", Product.class);
        Product p2 = context.getBean("product2", Product.class);
        Product p3 = context.getBean("product3", Product.class);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
    }
}
