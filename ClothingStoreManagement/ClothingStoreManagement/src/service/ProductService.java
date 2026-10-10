/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import exception.DuplicateIdException;
import exception.InvalidInputException;
import exception.ProductNotFoundException;
import model.Product;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // B1: Thêm sản phẩm mới + validate BR1, BR3, BR4, BR5, BR6
    public void addProduct(Product product) 
            throws DuplicateIdException, InvalidInputException {
        
        if (product == null) {
            throw new InvalidInputException("Thông tin sản phẩm không được null.");
        }

        // BR1: Product ID unique
        if (productRepository.existsById(product.getProductId())) {
            throw new DuplicateIdException(
                "Product ID đã tồn tại: " + product.getProductId()
            );
        }

        // BR3 & BR4: Không được để rỗng
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new InvalidInputException("Tên sản phẩm không được để trống.");
        }
        if (product.getCategory() == null || product.getCategory().trim().isEmpty()) {
            throw new InvalidInputException("Loại sản phẩm không được để trống.");
        }
        if (product.getSize() == null || product.getSize().trim().isEmpty()) {
            throw new InvalidInputException("Size không được để trống.");
        }
        if (product.getColor() == null || product.getColor().trim().isEmpty()) {
            throw new InvalidInputException("Màu sắc không được để trống.");
        }

        // BR5 & BR6: Giá > 0 và Số lượng >= 0
        if (product.getPrice() <= 0) {
            throw new InvalidInputException("Giá sản phẩm phải lớn hơn 0.");
        }
        if (product.getQuantity() < 0) {
            throw new InvalidInputException("Số lượng tồn kho không được âm.");
        }

        productRepository.add(product);
    }

    // B2: Cập nhật sản phẩm (không sửa ID)
    public void updateProduct(String id, String name, String category, 
                              String size, String color, 
                              Double price, Integer quantity)
            throws ProductNotFoundException, InvalidInputException {
        
        Product p = productRepository.findById(id);
        if (p == null) {
            throw new ProductNotFoundException("Không tìm thấy sản phẩm có ID: " + id);
        }

        if (name != null && !name.trim().isEmpty()) p.setName(name);
        if (category != null && !category.trim().isEmpty()) p.setCategory(category);
        if (size != null && !size.trim().isEmpty()) p.setSize(size);
        if (color != null && !color.trim().isEmpty()) p.setColor(color);

        if (price != null) {
            if (price <= 0) {
                throw new InvalidInputException("Giá sản phẩm phải lớn hơn 0.");
            }
            p.setPrice(price);
        }

        if (quantity != null) {
            if (quantity < 0) {
                throw new InvalidInputException("Số lượng không được âm.");
            }
            p.setQuantity(quantity);
        }
    }

    // Xóa sản phẩm theo ID
    public void removeProduct(String id) throws ProductNotFoundException {
        Product p = productRepository.findById(id);
        if (p == null) {
            throw new ProductNotFoundException("Không tìm thấy sản phẩm có ID: " + id);
        }
        productRepository.remove(p);
    }

    // B3: Xem tất cả sản phẩm
    public List<Product> getAllProducts() {
        return productRepository.getAll();
    }

    // Tìm kiếm theo ID
    public Product getProductById(String id) {
        return productRepository.findById(id);
    }

    // B4: Tìm kiếm theo tên, loại, size, hoặc màu
    public List<Product> searchProducts(String keyword) {
        List<Product> result = new ArrayList<>();
        String lowerKw = keyword.toLowerCase();
        for (Product p : productRepository.getAll()) {
            if (p.getName().toLowerCase().contains(lowerKw)
                    || p.getCategory().toLowerCase().contains(lowerKw)
                    || p.getSize().toLowerCase().contains(lowerKw)
                    || p.getColor().toLowerCase().contains(lowerKw)) {
                result.add(p);
            }
        }
        return result;
    }

    // Xem sản phẩm còn hàng (quantity > 0)
    public List<Product> getAvailableProducts() {
        List<Product> result = new ArrayList<>();
        for (Product p : productRepository.getAll()) {
            if (p.getQuantity() > 0) {
                result.add(p);
            }
        }
        return result;
    }

    // B11 & B16: Xem sản phẩm sắp hết hàng (BR18)
    public List<Product> getLowStockProducts() {
        List<Product> result = new ArrayList<>();
        for (Product p : productRepository.getAll()) {
            if (p.isLowStock()) {
                result.add(p);
            }
        }
        return result;
    }

    // B12: Cập nhật tồn kho nhanh
    public void updateStock(String id, int newQuantity) 
            throws ProductNotFoundException, InvalidInputException {
        if (newQuantity < 0) {
            throw new InvalidInputException("Số lượng tồn kho không được âm.");
        }
        Product p = productRepository.findById(id);
        if (p == null) {
            throw new ProductNotFoundException("Không tìm thấy sản phẩm có ID: " + id);
        }
        p.setQuantity(newQuantity);
    }
}