/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 * Custom exception được ném ra khi không tìm thấy sản phẩm trong hệ thống.
 */
public class ProductNotFoundException extends Exception {
    
    public ProductNotFoundException() {
        super("Lỗi: Không tìm thấy sản phẩm trong hệ thống!");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}