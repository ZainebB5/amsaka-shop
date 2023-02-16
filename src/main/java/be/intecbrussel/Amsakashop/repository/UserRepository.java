package be.intecbrussel.Amsakashop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import be.intecbrussel.Amsakashop.data.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{

    User findByUserNameAndPassword(String userName, String password);
    User findByUserName(String username);
    
}
