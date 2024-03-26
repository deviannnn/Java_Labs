package vn.edu.tdtu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Product p1 = context.getBean(Product.class);
        System.out.println(p1.toString());
        context.close();
    }
}
