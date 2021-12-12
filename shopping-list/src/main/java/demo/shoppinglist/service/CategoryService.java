package demo.shoppinglist.service;

import demo.shoppinglist.models.entity.Category;
import demo.shoppinglist.models.entity.CategoryNameEnum;

public interface CategoryService {

    void initCategories();

    Category findByName(CategoryNameEnum categoryName);
}
