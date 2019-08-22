package productmanager.productmanager.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @Autowired
    public ProductService service;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listProducts", service.listAll());
        return "index";
    }
    @RequestMapping("/new_product")
    public String showNewProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

}

