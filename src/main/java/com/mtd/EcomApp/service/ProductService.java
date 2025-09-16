package com.mtd.EcomApp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtd.EcomApp.entity.Product;
import com.mtd.EcomApp.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
    	product.setId(null);
    	return productRepository.save(product);
    }
    
    public Product getProductById(String id) {
    	// 2. Safe way to handle "not found"
    	return productRepository.findById(id)
    		.orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
    
    public List<Product> getProducts(){
    	return productRepository.findAll();
    }
    
    public boolean deleteProduct(String id) {
    	if (!productRepository.existsById(id)) {
    		return false;
    	}
    	productRepository.deleteById(id);
    	return true;
    }
    
    public Product updateProduct(Product product, String id) { // <-- 3. Method name corrected to camelCase
    	// 2. Find existing product safely
    	Product existingProduct = productRepository.findById(id).get();
    		
    	
    	// 4. Corrected update logic
    	existingProduct.setName(product.getName());
    	existingProduct.setDescription(product.getDescription());
    	existingProduct.setCategory(product.getCategory());
    	existingProduct.setPrice(product.getPrice());
    	existingProduct.setTags(product.getTags());
    	existingProduct.setStock(product.getStock());
    	
    	return productRepository.save(existingProduct);
    }
}