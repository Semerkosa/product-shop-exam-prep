package demo.shoppinglist.repository;

import demo.shoppinglist.models.entity.Category;
import demo.shoppinglist.models.entity.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<Category> findByName(CategoryNameEnum categoryName);
}
