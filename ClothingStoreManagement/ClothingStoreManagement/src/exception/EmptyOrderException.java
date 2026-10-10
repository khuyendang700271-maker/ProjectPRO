/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 * Custom exception được ném ra khi xác nhận đơn hàng rỗng.
 * Áp dụng cho BR10 (Đơn hàng phải có ít nhất 1 sản phẩm).
 */
public class EmptyOrderException extends Exception {
    
    public EmptyOrderException() {
        super("Lỗi: Đơn hàng phải có ít nhất 1 sản phẩm trước khi xác nhận!");
    }

    public EmptyOrderException(String message) {
        super(message);
    }
}