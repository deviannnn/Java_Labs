package org.example;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.validator.routines.UrlValidator;
public class Ex4 {
    public static void main(String[] args) {

        // Check if an URL is specified
        if (args.length == 0) {
            System.out.println("Please specify an URL to a file");
            return;
        }

        // Validate the URL
        String urlString = args[0];
        UrlValidator validator = new UrlValidator();
        if (!validator.isValid(urlString)) {
            System.out.println("This is not a valid URL");
            return;
        }

        // Download the file
        try {
            URL url = new URL(urlString);
            String fileName = urlString.substring(urlString.lastIndexOf("/") + 1);
            File file = new File(fileName);
            FileUtils.copyURLToFile(url, file);
            System.out.println("File downloaded successfully to: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error downloading file: " + e.getMessage());
        }
    }
}