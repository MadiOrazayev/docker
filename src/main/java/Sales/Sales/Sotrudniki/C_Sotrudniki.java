package Sales.Sales.Sotrudniki;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Sotrudniki {
    @GetMapping(value = "/sign-in")
    public String signIn(Model model) {
        return "signinpage";
    }
}
