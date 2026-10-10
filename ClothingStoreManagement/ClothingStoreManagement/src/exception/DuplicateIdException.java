/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 * Custom exception được ném ra khi ID sản phẩm hoặc khách hàng bị trùng lặp.
 * Áp dụng cho BR1 (Product ID unique) và BR2 (Customer ID unique).
 */
public class DuplicateIdException extends Exception {
    
    // Constructor mặc định với thông báo lỗi chung
    public DuplicateIdException() {
        super("Lỗi: ID này đã tồn tại trong hệ thống!");
    }

    // Constructor nhận vào thông báo lỗi chi tiết
    public DuplicateIdException(String message) {
        super(message);
    }
}