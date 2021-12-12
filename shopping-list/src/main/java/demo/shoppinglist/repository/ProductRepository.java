package demo.shoppinglist.repository;

import demo.shoppinglist.models.entity.CategoryNameEnum;
import demo.shoppinglist.models.entity.Product;
import demo.shoppinglist.models.view.ProductViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("SELECT SUM(p.price) FROM Product p")
    BigDecimal getSumOfAllProducts();

    List<Product> findAllByCategory_name(CategoryNameEnum categoryNameEnum);
}
