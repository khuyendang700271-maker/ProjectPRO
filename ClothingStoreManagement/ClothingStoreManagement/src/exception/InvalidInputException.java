/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 * Custom exception được ném ra khi dữ liệu đầu vào không hợp lệ.
 * Áp dụng cho validate dữ liệu (BR17).
 */
public class InvalidInputException extends Exception {
    
    public InvalidInputException() {
        super("Lỗi: Dữ liệu đầu vào không hợp lệ!");
    }

    public InvalidInputException(String message) {
        super(message);
    }
}
