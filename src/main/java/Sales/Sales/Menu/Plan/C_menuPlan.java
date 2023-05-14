package Sales.Sales.Menu.Plan;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_menuPlan {
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_COOK')")
    @GetMapping(value = "/menuplan")
    public String menuplan(){
        return "menuplan";
    }
}
