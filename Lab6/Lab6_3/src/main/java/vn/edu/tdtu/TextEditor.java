package vn.edu.tdtu;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class TextEditor {
    private String text;

    @Autowired
    @Qualifier("plainTextWriter")
    private TextWriter writer;

    public void input(String text) {
        this.text = text;
    }

    public void save(String fileName) {
        writer.write(fileName, text);
    }
}
