package productmanager.productmanager.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

    @Autowired
    public ProductService service;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listProducts", service.listAll());
        return "index";
    }

//    adding new product
    @RequestMapping("/new_product")
    public String showNewProductForm(@ModelAttribute("product") Product product){
        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product){
        service.save(product);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public String showEditProductForm(Model model, @PathVariable(name = "id") long id){
        Product product = service.get( id);
        model.addAttribute("product",product);
        return "edit_product";
    }
    @RequestMapping("/delete/{id}")
    public String deleteProduct( @PathVariable(name = "id") long id){
        service.delete(id);
        return "redirect:/";
    }



}

