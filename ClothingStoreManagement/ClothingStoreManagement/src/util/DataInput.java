/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;

/**
 * Lớp tiện ích hỗ trợ đọc dữ liệu an toàn từ bàn phím (Console).
 */
public class DataInput {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Đọc một chuỗi không được để trống từ người dùng.
     */
    public static String getString(String message) {
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Lỗi: Không được để trống, vui lòng nhập lại!");
        }
    }

    /**
     * Đọc một số nguyên trong khoảng [min, max].
     */
    public static int getInt(String message, int min, int max) {
        int value;
        while (true) {
            try {
                System.out.print(message);
                value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Lỗi: Giá trị phải nằm trong khoảng từ " + min + " đến " + max + "!");
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ!");
            }
        }
    }

    /**
     * Đọc một số thực (dùng cho giá tiền) lớn hơn min.
     */
    public static double getDouble(String message, double min) {
        double value;
        while (true) {
            try {
                System.out.print(message);
                value = Double.parseDouble(scanner.nextLine().trim());
                if (value > min) {
                    return value;
                }
                System.out.println("Lỗi: Giá trị phải lớn hơn " + min + "!");
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số thực hợp lệ!");
            }
        }
    }
}