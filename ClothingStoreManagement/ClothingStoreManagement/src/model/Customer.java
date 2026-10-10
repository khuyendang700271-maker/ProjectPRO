/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public abstract class Customer {
    // ===== ATTRIBUTES =====
    private String customerId;
    private String fullName;
    private String phone;
    private String address;

    // ===== CONSTRUCTOR =====
    public Customer() {
    }

    public Customer(String customerId, String fullName, 
                    String phone, String address) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
    }

    // ===== GETTERS =====
    // Customer ID không có setter để tuân thủ BR2 (không sửa ID sau khi tạo)
    public String getCustomerId() { return customerId; }
    public String getFullName() { return fullName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    // ===== SETTERS =====
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAddress(String address) { this.address = address; }

    // ===== ABSTRACT METHODS =====
    public abstract double calculateDiscount(double subtotal);
    public abstract String getMembershipType();

    // ===== TO STRING =====
    @Override
    public String toString() {
        return String.format("ID: %s | Ten: %s | SDT: %s | Dia chi: %s | Loai: %s",
                customerId, fullName, phone, address, getMembershipType());
    }
}
