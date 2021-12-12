package demo.shoppinglist.service;

import demo.shoppinglist.models.entity.CategoryNameEnum;
import demo.shoppinglist.models.service.ProductServiceModel;
import demo.shoppinglist.models.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void addProduct(ProductServiceModel productServiceModel);

    BigDecimal getSumOfAllProducts();

    List<ProductViewModel> findAllByCategoryName(CategoryNameEnum drink);

    void buyProductById(String id);
}
