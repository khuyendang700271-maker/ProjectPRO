/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private final List<Customer> customerList = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public boolean removeCustomer(String customerId) {
        Customer customer = findById(customerId);
        if (customer == null) {
            return false;
        }
        customerList.remove(customer);
        return true;
    }

    public boolean updateCustomer(Customer customer) {
        Customer existing = findById(customer.getCustomerId());
        if (existing == null) {
            return false;
        }
        int index = customerList.indexOf(existing);
        customerList.set(index, customer);
        return true;
    }

    public Customer findById(String customerId) {
        for (Customer c : customerList) {
            if (c.getCustomerId().equalsIgnoreCase(customerId)) {
                return c;
            }
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        return customerList;
    }

    public List<Customer> findByKeyword(String keyword) {
        List<Customer> result = new ArrayList<>();
        if (keyword == null || keyword.trim().isEmpty()) {
            return result;
        }
        String key = keyword.toLowerCase();
        for (Customer c : customerList) {
            if (c.getFullName().toLowerCase().contains(key)
                    || c.getPhone().contains(key)) {
                result.add(c);
            }
        }
        return result;
    }

    // ===== THÊM METHOD NÀY =====
    public boolean existsById(String customerId) {
        return findById(customerId) != null;
    }
}
