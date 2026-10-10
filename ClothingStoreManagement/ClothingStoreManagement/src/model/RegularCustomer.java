/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class RegularCustomer extends Customer {

    public RegularCustomer() {
        super();
    }

    public RegularCustomer(String customerId, String fullName, 
                           String phone, String address) {
        super(customerId, fullName, phone, address);
    }

    // BR14: Khách thường không giảm giá
    @Override
    public double calculateDiscount(double subtotal) {
        return 0;
    }

    @Override
    public String getMembershipType() {
        return "Regular";
    }
}
