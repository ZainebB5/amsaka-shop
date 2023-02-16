package be.intecbrussel.Amsakashop.services.implementations;

import be.intecbrussel.Amsakashop.data.Category;
import be.intecbrussel.Amsakashop.repository.CategoryRepository;
import be.intecbrussel.Amsakashop.services.interfaces.CategoryService;


import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(Category category) {

    }


    @Override
    public void removeCategory(int id) {

    }

    @Override
    public Optional<Category> getCaategoryById(int id) {
        return Optional.empty();
    }
}
