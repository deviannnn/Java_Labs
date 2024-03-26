package vn.edu.tdtu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("appConfig.xml");
        Product p1 = (Product) context.getBean("product1");
        Product p2 = (Product) context.getBean("product2");
        Product p3 = (Product) context.getBean("product3");
        System.out.println("product1: " + p1.toString());
        System.out.println("product2: " + p2.toString());
        System.out.println("product3: " + p3.toString());
    }
}
