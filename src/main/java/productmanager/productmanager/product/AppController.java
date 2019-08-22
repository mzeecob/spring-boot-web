package productmanager.productmanager.product;

import org.dom4j.rule.Mode;
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

}

