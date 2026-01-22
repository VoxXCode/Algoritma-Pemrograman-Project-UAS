package org.example.utils;

import java.util.Scanner;

public class InputValidator {
    public static int getInt(Scanner scanner, String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                break;
            } else {
                System.out.println("Error: Masukkan harus berupa angka bulat.");
                scanner.next(); // Membersihkan buffer
            }
        }
        return input;
    }
}