package vn.edu.tdtu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PlainTextWriter implements TextWriter {
    public void write(String fileName, String text) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(text);
            bufferedWriter.close();
            System.out.println("Text saved to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
