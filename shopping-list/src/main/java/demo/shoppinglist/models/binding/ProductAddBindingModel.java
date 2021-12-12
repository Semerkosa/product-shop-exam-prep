package demo.shoppinglist.models.binding;

import demo.shoppinglist.models.entity.CategoryNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {

    @NotBlank(message = "Name should not be an empty string!")
    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters (inclusive 3 and 20)!")
    private String name;

    @NotBlank(message = "Name should not be an empty string!")
    @Size(min = 5, message = "Description min length must be minimum 5(inclusive) characters!")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "Date can not be in the past!")
    private LocalDateTime neededBefore;

    @NotNull(message = "Enter a valid price!")
    @DecimalMin(value = "0", message = "Price must be positive!")
    private BigDecimal price;

    @NotNull(message = "Category must be selected!")
    private CategoryNameEnum category;

    public ProductAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ProductAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductAddBindingModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ProductAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
