/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Legion
 */
import model.Product;
import model.Customer;
import model.RegularCustomer;
import model.VIPCustomer;
import repository.ProductRepository;
import repository.CustomerRepository;
import service.ProductService;
import service.CustomerService;
import exception.DuplicateIdException;
import exception.InvalidInputException;
import exception.ProductNotFoundException;

public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   TEST LAB 2 - CLOTHING STORE APP");
        System.out.println("========================================");

        testProduct();
        testCustomer();

        System.out.println("\n========================================");
        System.out.println("   TEST HOAN THANH!");
        System.out.println("========================================");
    }

    // ===== TEST PRODUCT =====
    private static void testProduct() {
        System.out.println("\n--- TEST PRODUCT MODULE ---");
        ProductRepository repo = new ProductRepository();
        ProductService service = new ProductService(repo);

        // Test 1: Thêm sản phẩm thành công
        try {
            service.addProduct(new Product("P01", "Basic T-Shirt", "T-Shirt",
                                           "M", "Black", 250000, 50));
            System.out.println("✅ Them P01 thanh cong!");
        } catch (DuplicateIdException | InvalidInputException e) {
            System.out.println("❌ Loi: " + e.getMessage());
        }

        // Test 2: Thêm sản phẩm thứ 2
        try {
            service.addProduct(new Product("P02", "Jeans", "Trousers",
                                           "L", "Blue", 550000, 20));
            System.out.println("✅ Them P02 thanh cong!");
        } catch (DuplicateIdException | InvalidInputException e) {
            System.out.println("❌ Loi: " + e.getMessage());
        }

        // Test 3: Thêm sản phẩm trùng ID → bắt exception
        try {
            service.addProduct(new Product("P01", "Duplicate", "T-Shirt",
                                           "S", "White", 200000, 10));
            System.out.println("❌ Test 3 FAIL - Khong bat duoc exception!");
        } catch (DuplicateIdException | InvalidInputException e) {
            System.out.println("✅ Test 3 PASS - Bat duoc loi: " + e.getMessage());
        }

        // Test 4: Tìm sản phẩm theo ID
        Product found = service.getProductById("P01");
        if (found != null) {
            System.out.println("✅ Tim thay: " + found);
        } else {
            System.out.println("❌ Khong tim thay P01");
        }

        // Test 5: In tất cả sản phẩm
        System.out.println("\n--- Danh sach san pham ---");
        for (Product p : service.getAllProducts()) {
            System.out.println("   " + p);
        }
    }

    // ===== TEST CUSTOMER =====
    private static void testCustomer() {
        System.out.println("\n--- TEST CUSTOMER MODULE ---");
        CustomerService service = new CustomerService();

        // Test 1: Thêm RegularCustomer
        try {
            service.addCustomer(new RegularCustomer("C01", "Nguyen Van A",
                                                    "0901234567", "HCM"));
            System.out.println("✅ Them Regular C01 thanh cong!");
        } catch (DuplicateIdException | InvalidInputException e) {
            System.out.println("❌ Loi: " + e.getMessage());
        }

        // Test 2: Thêm VIPCustomer
        try {
            service.addCustomer(new VIPCustomer("C02", "Tran Thi B",
                                                "0987654321", "HN"));
            System.out.println("✅ Them VIP C02 thanh cong!");
        } catch (DuplicateIdException | InvalidInputException e) {
            System.out.println("❌ Loi: " + e.getMessage());
        }

        // Test 3: Thêm trùng ID → bắt exception
        try {
            service.addCustomer(new VIPCustomer("C01", "Duplicate",
                                                "0900000000", "HCM"));
            System.out.println("❌ Test 3 FAIL - Khong bat duoc exception!");
        } catch (DuplicateIdException | InvalidInputException e) {
            System.out.println("✅ Test 3 PASS - Bat duoc loi: " + e.getMessage());
        }

        // Test 4: POLYMORPHISM
        System.out.println("\n--- Test Polymorphism ---");
        Customer regular = service.findById("C01");
        Customer vip = service.findById("C02");

        if (regular != null && vip != null) {
            double subtotal = 1000000;
            System.out.println("   Regular discount (1,000,000 VND): "
                             + regular.calculateDiscount(subtotal) + " VND");
            System.out.println("   VIP discount (1,000,000 VND): "
                             + vip.calculateDiscount(subtotal) + " VND");

            if (regular.calculateDiscount(subtotal) == 0
                && vip.calculateDiscount(subtotal) == 100000) {
                System.out.println("✅ Polymorphism hoat dong dung!");
            } else {
                System.out.println("❌ Polymorphism SAI!");
            }
        }

        // Test 5: In tất cả khách hàng
        System.out.println("\n--- Danh sach khach hang ---");
        for (Customer c : service.getAllCustomers()) {
            System.out.println("   " + c);
        }
    }
}