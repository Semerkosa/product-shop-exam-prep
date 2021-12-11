package demo.shoppinglist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(HttpSession session) {
        return session.getAttribute("user") == null
                ? "index" : "home";
    }
}
