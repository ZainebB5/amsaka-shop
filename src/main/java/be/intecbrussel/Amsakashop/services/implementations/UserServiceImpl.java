package be.intecbrussel.Amsakashop.services.implementations;

import be.intecbrussel.Amsakashop.data.User;
import be.intecbrussel.Amsakashop.repository.UserRepository;
import be.intecbrussel.Amsakashop.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userrepository;
    @Autowired
    public UserServiceImpl(UserRepository userrepository) {
        this.userrepository = userrepository;
    }


    @Override
    public User getUserByUserNameAndPassword(String userName, String password) {
        return userrepository.findByUserNameAndPassword(userName,password);
    }
}
