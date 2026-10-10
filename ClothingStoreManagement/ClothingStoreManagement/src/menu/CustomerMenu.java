/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import exception.DuplicateIdException;
import exception.InvalidInputException;
import model.Customer;
import service.CustomerService;
import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
    private final CustomerService service = new CustomerService();
    private final Scanner sc = new Scanner(System.in);
    
    public void displayMenu() {
        while (true) {
            System.out.println("\n========== QUAN LY KHACH HANG ==========");
            System.out.println("1. Them khach hang moi");
            System.out.println("2. Cap nhat khach hang");
            System.out.println("3. Xem tat ca khach hang");
            System.out.println("4. Tim kiem khach hang");
            System.out.println("5. Xoa khach hang");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Chon chuc nang: ");
            
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: addCustomer(); break;
                    case 2: updateCustomer(); break;
                    case 3: viewAll(); break;
                    case 4: searchCustomer(); break;
                    case 5: deleteCustomer(); break;
                    case 0: return;
                    default: System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap so!");
            }
        }
    }
    
    private void addCustomer() {
        try {
            System.out.print("Nhap ID khach hang: ");
            String id = sc.nextLine();
            System.out.print("Nhap ten: ");
            String name = sc.nextLine();
            System.out.print("Nhap SDT: ");
            String phone = sc.nextLine();
            System.out.print("Nhap dia chi: ");
            String address = sc.nextLine();
            System.out.print("Nhap loai (Regular/VIP): ");
            String type = sc.nextLine();
            
            service.addCustomer(id, name, phone, address, type);
            System.out.println("=> Them khach hang thanh cong!");
        } catch (DuplicateIdException | InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void updateCustomer() {
        try {
            System.out.print("Nhap ID khach hang can sua: ");
            String id = sc.nextLine();
            
            if (service.findById(id) == null) {
                System.out.println("Khong tim thay khach hang!");
                return;
            }
            
            System.out.print("Nhap ten moi: ");
            String name = sc.nextLine();
            System.out.print("Nhap SDT moi: ");
            String phone = sc.nextLine();
            System.out.print("Nhap dia chi moi: ");
            String address = sc.nextLine();
