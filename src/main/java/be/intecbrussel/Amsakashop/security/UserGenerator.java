package be.intecbrussel.Amsakashop.security;

import be.intecbrussel.Amsakashop.data.User;
import be.intecbrussel.Amsakashop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserGenerator implements CommandLineRunner {

    @Autowired
    private UserRepository userrepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User admin = new User("admin", passwordEncoder.encode("admin"), "ROLE_ADMIN");
        User user = new User("user", passwordEncoder.encode("user"),  "ROLE_USER");
        userrepository.save(admin);
        userrepository.save(user);
    }
}
