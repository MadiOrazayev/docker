package Sales.Sales;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Main {
    @GetMapping(value = "/")
    public String index(Model model){
        return "main_layout";
    }
}
