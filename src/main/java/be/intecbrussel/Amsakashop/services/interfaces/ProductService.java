package be.intecbrussel.Amsakashop.services.interfaces;

import be.intecbrussel.Amsakashop.data.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(int id);
    List<Product> getAllProducts();
    //List<Product> getAllProductsByCategory(String category);
}
