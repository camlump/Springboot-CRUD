package camlump.com.java.jpademo.service;

import camlump.com.java.jpademo.model.Product;
import camlump.com.java.jpademo.repository.ProductRepsository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepsository productRepsository;

    public Product savedProduct(Product product) {
        return productRepsository.save(product);
    }

    public Product getProduct(long productId) {
        return productRepsository.findById(productId).orElseThrow(() -> new RuntimeException("not found"));
    }

    public List<Product> getProducts() {
        return productRepsository.findAll();
    }


    public Product updateProduct(long productId, Product product) {
        Product existingProduct = productRepsository.findById(productId).orElseThrow(() -> new RuntimeException("not found"));
        existingProduct.setProductName(product.getProductName());
        existingProduct.setColor(product.getColor());
        existingProduct.setPrice(product.getPrice());
        productRepsository.save(existingProduct);
        return existingProduct;
    }

    public Product deleteProduct(long productId) {
        Product existingProduct = productRepsository.findById(productId).orElseThrow(() -> new RuntimeException("not found"));
        productRepsository.deleteById(productId);
        return existingProduct;
    }

    public  List<Product> getProductsByName(String productName) {
        return productRepsository.getProductsByName(productName);
    }

}
