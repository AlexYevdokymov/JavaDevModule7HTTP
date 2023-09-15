package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

//        System.out.println(HttpStatusChecker.getStatusImage(212));
//        HttpStatusImageDownloader.downloadStatusImage(203);

        HttpImageStatusCli.askStatus();
    }
}