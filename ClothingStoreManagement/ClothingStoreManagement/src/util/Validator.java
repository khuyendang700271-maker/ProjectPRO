/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

public class Validator {

    // Kiểm tra chuỗi không rỗng
    public static boolean isNotBlank(String str) {
        return str != null && !str.trim().isEmpty();
    }

    // Alias của isNotBlank — cho tương thích
    public static boolean isNotEmpty(String str) {
        return isNotBlank(str);
    }

    // Kiểm tra giá > 0 (BR5)
    public static boolean isValidPrice(double price) {
        return price > 0;
    }

    // Kiểm tra số lượng >= 0 (BR6)
    public static boolean isValidQuantity(int quantity) {
        return quantity >= 0;
    }

    // Kiểm tra ID hợp lệ
    public static boolean isValidId(String id) {
        return isNotBlank(id) && !id.contains(" ");
    }

    // Alias của isValidId — cho Customer
    public static boolean isValidCustomerId(String id) {
        return isValidId(id);
    }

    // Kiểm tra SĐT (bắt đầu bằng 0, dài 10-11 chữ số)
    public static boolean isValidPhone(String phone) {
        if (!isNotBlank(phone)) {
            return false;
        }
        return phone.matches("^0\\d{9,10}$");
    }

    // Kiểm tra loại thành viên
    public static boolean isValidMembershipType(String type) {
        if (type == null) return false;
        return type.equalsIgnoreCase("Regular") 
            || type.equalsIgnoreCase("VIP");
    }
}
