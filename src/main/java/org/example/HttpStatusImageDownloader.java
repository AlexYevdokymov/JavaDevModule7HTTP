package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class HttpStatusImageDownloader {
    public static void downloadStatusImage(int code) throws IOException, InterruptedException, PageNotFoundException {
        String url = null;
        try {
            url = HttpStatusChecker.getStatusImage(code);
            InputStream in = new URL(url).openStream();
            Files.copy(in, Paths.get("catImage.jpg"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image with status code " + code + " downloaded successfully");
        } catch (PageNotFoundException e) {
            System.out.println("There is not image for HTTP status " + code);
            throw new PageNotFoundException();
        }
    }
}

