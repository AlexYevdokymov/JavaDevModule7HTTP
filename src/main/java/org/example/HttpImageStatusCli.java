package org.example;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public static void askStatus() throws IOException, InterruptedException {
        System.out.println("Enter HTTP status code");
        Scanner scanner = new Scanner(System.in);
        boolean isCorrectNum = false;
        int intCode = 0;
        while (!isCorrectNum) {
            String code = scanner.nextLine();
            if (code.matches("[-+]?\\d+")) {
                intCode = Integer.parseInt(code);
                isCorrectNum = true;
                try {
                    HttpStatusImageDownloader.downloadStatusImage(intCode);
                } catch (PageNotFoundException e) {
                    System.out.println("Enter valid status code!");
                    isCorrectNum = false;
                }
            } else {
                System.out.println("Please enter valid number");
            }
        }
    }
}
