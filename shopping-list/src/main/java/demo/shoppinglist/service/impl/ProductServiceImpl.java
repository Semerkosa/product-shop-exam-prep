package demo.shoppinglist.service.impl;

import demo.shoppinglist.models.entity.CategoryNameEnum;
import demo.shoppinglist.models.entity.Product;
import demo.shoppinglist.models.service.ProductServiceModel;
import demo.shoppinglist.models.view.ProductViewModel;
import demo.shoppinglist.repository.ProductRepository;
import demo.shoppinglist.service.CategoryService;
import demo.shoppinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel) {
        Product product = modelMapper.map(productServiceModel, Product.class);
        product.setCategory(categoryService.findByName(productServiceModel.getCategory()));

        productRepository.saveAndFlush(product);
    }

    @Override
    public BigDecimal getSumOfAllProducts() {
        return productRepository.getSumOfAllProducts() != null
                ? productRepository.getSumOfAllProducts()
                : new BigDecimal(0);
    }

    @Override
    public List<ProductViewModel> findAllByCategoryName(CategoryNameEnum categoryNameEnum) {
        return productRepository
                .findAllByCategory_name(categoryNameEnum)
                .stream()
                .map(product ->  modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyProductById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAllProducts() {
        productRepository.deleteAll();
    }
}
