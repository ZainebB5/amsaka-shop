package be.intecbrussel.Amsakashop.services.interfaces;

import be.intecbrussel.Amsakashop.data.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProduct();
    Optional<Product> getProductById(int id);
    void addProduct(Product product);

    void removeProductById(int id);
}
