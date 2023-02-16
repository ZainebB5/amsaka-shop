package be.intecbrussel.Amsakashop.services.interfaces;



import be.intecbrussel.Amsakashop.data.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<be.intecbrussel.Amsakashop.data.Category> getAllCategory();

    void addCategory(Category category);

    void removeCategory(int id);

    Optional<Category> getCaategoryById(int id);

}
