package com.platzi.Market.Domain.repository;

import com.platzi.Market.Domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarceProducts(int quantity);
    Optional<List<Product>> getProduct(int productId);
    Product save(Product product);
    void delete(int ProductID);

}
