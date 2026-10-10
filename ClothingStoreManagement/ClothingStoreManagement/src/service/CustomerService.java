/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import exception.DuplicateIdException;
import exception.InvalidInputException;
import model.Customer;
import model.RegularCustomer;
import model.VIPCustomer;
import repository.CustomerRepository;
import util.Validator;
import java.util.List;

public class CustomerService {
    private final CustomerRepository repo = new CustomerRepository();

    // Thêm khách hàng — nhận 1 object Customer
    public void addCustomer(Customer customer) 
            throws DuplicateIdException, InvalidInputException {
        
        if (customer == null) {
            throw new InvalidInputException("Thông tin khách hàng không được null.");
        }

        // BR2: Kiểm tra ID trùng
        if (repo.existsById(customer.getCustomerId())) {
            throw new DuplicateIdException(
                "Customer ID đã tồn tại: " + customer.getCustomerId()
            );
        }

        // BR17: Validate đầu vào
        if (!Validator.isNotBlank(customer.getFullName())) {
            throw new InvalidInputException("Tên khách hàng không được rỗng!");
        }
        if (!Validator.isValidPhone(customer.getPhone())) {
            throw new InvalidInputException("SĐT phải có 10-11 chữ số, bắt đầu bằng 0!");
        }
        if (!Validator.isNotBlank(customer.getAddress())) {
            throw new InvalidInputException("Địa chỉ không được rỗng!");
        }

        repo.addCustomer(customer);
    }

    // Cập nhật khách hàng (BR2: không cho sửa ID)
    public boolean updateCustomer(String id, String name, 
                                  String phone, String address)
            throws InvalidInputException {
        Customer existing = repo.findById(id);
        if (existing == null) {
            return false;
        }

        if (!Validator.isNotBlank(name)) {
            throw new InvalidInputException("Tên khách hàng không được rỗng!");
        }
        if (!Validator.isValidPhone(phone)) {
            throw new InvalidInputException("SĐT phải có 10-11 chữ số, bắt đầu bằng 0!");
        }
        if (!Validator.isNotBlank(address)) {
            throw new InvalidInputException("Địa chỉ không được rỗng!");
        }

        existing.setFullName(name);
        existing.setPhone(phone);
        existing.setAddress(address);
        return true;
    }

    // Xóa khách hàng
    public boolean deleteCustomer(String id) {
        return repo.removeCustomer(id);
    }

    // Tìm theo ID
    public Customer findById(String id) {
        return repo.findById(id);
    }

    // Lấy tất cả
    public List<Customer> getAllCustomers() {
        return repo.getAllCustomers();
    }

    // Tìm theo tên hoặc SĐT
    public List<Customer> findByKeyword(String keyword) {
        return repo.findByKeyword(keyword);
    }
}
