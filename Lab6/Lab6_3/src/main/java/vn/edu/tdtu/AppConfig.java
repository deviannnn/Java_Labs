package vn.edu.tdtu;

import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {
    @Bean(name = "plainTextWriter")
    public TextWriter plainTextWriter() {
        return new PlainTextWriter();
    }

    @Bean(name = "pdfTextWriter")
    public TextWriter pdfTextWriter() {
        return new PdfTextWriter();
    }

    @Bean
    public TextEditor textEditor() {
        return new TextEditor();
    }
}
