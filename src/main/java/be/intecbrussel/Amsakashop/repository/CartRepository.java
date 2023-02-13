package be.intecbrussel.Amsakashop.repository;

import be.intecbrussel.Amsakashop.data.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {


}
