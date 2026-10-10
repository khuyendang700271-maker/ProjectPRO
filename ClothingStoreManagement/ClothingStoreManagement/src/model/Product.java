/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Product {
    // ===== ATTRIBUTES =====
    private String productId;
    private String name;
    private String category;
    private String size;
    private String color;
    private double price;
    private int quantity;

    // ===== CONSTRUCTOR =====
    public Product(String productId, String name, String category, 
                   String size, String color, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.size = size;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }

    // ===== GETTERS =====
    // Product ID không có setter để tuân thủ BR1 (không sửa ID sau khi tạo)
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getSize() { return size; }
    public String getColor() { return color; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    // ===== SETTERS =====
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setSize(String size) { this.size = size; }
    public void setColor(String color) { this.color = color; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // ===== BUSINESS METHODS =====
    // BR18: Sản phẩm sắp hết khi quantity <= 5
    public boolean isLowStock() {
        return this.quantity <= 5;
    }

    public boolean isAvailable() {
        return this.quantity > 0;
    }

    // ===== FILE I/O METHODS =====
    // Chuyển object thành chuỗi để lưu file
    public String toFileString() {
        return productId + "|" + name + "|" + category + "|" + 
               size + "|" + color + "|" + price + "|" + quantity;
    }

    // Chuyển chuỗi từ file thành object
    public static Product fromFileString(String line) {
        String[] parts = line.split("\\|");
        if (parts.length == 7) {
            try {
                return new Product(
                    parts[0], parts[1], parts[2], parts[3], parts[4],
                    Double.parseDouble(parts[5]),
                    Integer.parseInt(parts[6])
                );
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

    // ===== TO STRING =====
    @Override
    public String toString() {
        return String.format("ID: %s | Ten: %s | Loai: %s | Size: %s | Mau: %s | Gia: %.0f | SL: %d",
                productId, name, category, size, color, price, quantity);
    }
}


