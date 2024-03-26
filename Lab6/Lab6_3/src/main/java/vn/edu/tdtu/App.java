package vn.edu.tdtu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TextEditor textEditor = context.getBean(TextEditor.class);
        textEditor.input("Hello Lab6 Exercise3");
        textEditor.save("output.txt");
        context.close();
    }
}
