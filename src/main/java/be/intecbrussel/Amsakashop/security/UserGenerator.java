package be.intecbrussel.Amsakashop.security;

import be.intecbrussel.Amsakashop.data.User;
import be.intecbrussel.Amsakashop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserGenerator implements CommandLineRunner {

    @Autowired
    private UserRepository userrepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User admni1 = new User("admin@gmail.com", passwordEncoder.encode("admin"), "ROLE_ADMIN");
        User admni2 = new User("user@gmail.com", passwordEncoder.encode("user"),  "ROLE_USER");
        userrepository.save(admni1);
        userrepository.save(admni2);
    }
}
