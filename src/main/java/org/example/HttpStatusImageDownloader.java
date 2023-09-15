package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class HttpStatusImageDownloader {
    public static void downloadStatusImage(int code) throws IOException, InterruptedException {
        String url = HttpStatusChecker.getStatusImage(code);
        if (url.equals("Not found")) {
            System.out.println("There is not image for HTTP status " + code);
            return; }
        else {
            InputStream in = new URL(url).openStream();
            Files.copy(in, Paths.get("catImage.jpg"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image with status code " + code + " downloaded successfully");
            }
    }
}

