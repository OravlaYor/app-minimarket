package com.platzi.Market.Domain.Service;

import com.platzi.Market.Domain.Product;
import com.platzi.Market.Domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
@Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<List<Product>> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }
    public boolean delete(int ProductID){
        return getProduct(ProductID).map(products -> {
            productRepository.delete(ProductID);
            return true;
        }).orElse(false);

        /* otro camino
         if(getProduct(ProductID).ispresent()){
         productRepository.delete(ProductID);
         return true;
         }else{
         return false;
         }*/
    }
}
