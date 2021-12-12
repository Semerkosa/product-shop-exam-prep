package demo.shoppinglist.web;

import demo.shoppinglist.models.entity.CategoryNameEnum;
import demo.shoppinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String home(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("totalSum", productService.getSumOfAllProducts());

        model.addAttribute("drinks", productService.findAllByCategoryName(CategoryNameEnum.DRINK));
        model.addAttribute("foods", productService.findAllByCategoryName(CategoryNameEnum.FOOD));
        model.addAttribute("others", productService.findAllByCategoryName(CategoryNameEnum.OTHER));
        model.addAttribute("households", productService.findAllByCategoryName(CategoryNameEnum.HOUSEHOLD));

        return "home";
    }
}
