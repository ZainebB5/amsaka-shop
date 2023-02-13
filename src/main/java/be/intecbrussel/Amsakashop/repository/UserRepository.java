package be.intecbrussel.Amsakashop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import be.intecbrussel.Amsakashop.data.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{

    User findByMailAndPassword(String mail, String passWord);
    User findByMail(String username);
    
}
