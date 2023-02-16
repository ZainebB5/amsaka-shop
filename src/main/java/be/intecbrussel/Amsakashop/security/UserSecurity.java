package be.intecbrussel.Amsakashop.security;

import be.intecbrussel.Amsakashop.data.User;
import be.intecbrussel.Amsakashop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Set;

public class UserSecurity implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User dbUser = userRepository.findByUserName(userName);
        if (dbUser == null){
            throw new UsernameNotFoundException("This account : "+ userName +" does not exist");
        }
        return new  org.springframework.security.core.userdetails.User(
                dbUser.getUserName(),
                dbUser.getPassWord(),
                Set.of(() -> dbUser.getRole())
        );
    }
}
