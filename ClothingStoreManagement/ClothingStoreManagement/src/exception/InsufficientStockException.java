/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 * Custom exception được ném ra khi số lượng tồn kho không đủ để bán.
 * Áp dụng cho BR9 (Số lượng bán <= tồn kho).
 */
public class InsufficientStockException extends Exception {
    
    public InsufficientStockException() {
        super("Lỗi: Số lượng sản phẩm trong kho không đủ!");
    }

    public InsufficientStockException(String message) {
        super(message);
    }
}
