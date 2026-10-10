/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class VIPCustomer extends Customer {
    // BR15: Khách VIP giảm 10%
    public static final double DISCOUNT_RATE = 0.10;
    
    public VIPCustomer() {
        super();
    }
    
    public VIPCustomer(String customerId, String fullName, String phone, String address) {
        super(customerId, fullName, phone, address);
    }
    
    @Override
    public double calculateDiscount(double subtotal) {
        return subtotal * DISCOUNT_RATE;
    }
    
    @Override
    public String getMembershipType() {
        return "VIP";
    }
}