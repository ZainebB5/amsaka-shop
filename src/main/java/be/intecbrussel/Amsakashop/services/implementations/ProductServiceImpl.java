package be.intecbrussel.Amsakashop.services.implementations;

import be.intecbrussel.Amsakashop.data.Product;
import be.intecbrussel.Amsakashop.repository.ProductRepository;
import be.intecbrussel.Amsakashop.services.interfaces.ProductService;
import be.intecbrussel.Amsakashop.services.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return Optional.empty();
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void removeProductById(int id) {

    }


}
