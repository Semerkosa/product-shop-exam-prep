package demo.shoppinglist.service.impl;

import demo.shoppinglist.models.entity.Category;
import demo.shoppinglist.models.entity.CategoryNameEnum;
import demo.shoppinglist.repository.CategoryRepository;
import demo.shoppinglist.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values()).
                    forEach(name -> {
                        String description = "Description for " + name;
                        categoryRepository.saveAndFlush(new Category(name, description));
                    });
        }
    }
}
