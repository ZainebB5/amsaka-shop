package be.intecbrussel.Amsakashop.services.implementations;

import be.intecbrussel.Amsakashop.data.Product;
import be.intecbrussel.Amsakashop.repository.ProductRepository;
import be.intecbrussel.Amsakashop.services.interfaces.ProductService;
import be.intecbrussel.Amsakashop.services.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(int id) {

        return productRepository.getOne(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


}
