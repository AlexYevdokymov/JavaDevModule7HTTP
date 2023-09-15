package org.example;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public static void askStatus() throws IOException, InterruptedException {
        System.out.println("Enter HTTP status code");
        Scanner scanner = new Scanner(System.in);
        boolean isNum = false;
        int intCode = 0;
        while (!isNum) {
            String code = scanner.nextLine();
            if (code.matches("[-+]?\\d+")) {
                intCode = Integer.parseInt(code);
                isNum = true;
            } else {
                System.out.println("Please enter valid number");
            }
        }
        HttpStatusImageDownloader.downloadStatusImage(intCode);
    }
}
