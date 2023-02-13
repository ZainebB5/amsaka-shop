package be.intecbrussel.Amsakashop.services.interfaces;


import be.intecbrussel.Amsakashop.data.User;

public interface UserService {

    User getUserByMailAndPassword(String mail, String pasword);

}
