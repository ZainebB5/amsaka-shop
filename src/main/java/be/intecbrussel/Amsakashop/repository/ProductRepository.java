package be.intecbrussel.Amsakashop.repository;

import be.intecbrussel.Amsakashop.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByCategoryId(int categoryId);
    List<Product> findByCategory(String category);

}
