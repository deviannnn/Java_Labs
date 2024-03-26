package vn.edu.tdtu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TextEditor {
    private String text;
    @Autowired
    @Qualifier("pdfTextWriter")
    private TextWriter writer;

    public void input(String text) {
        this.text = text;
    }

    public void save(String fileName) {
        writer.write(fileName, text);
    }
}
