package Sales.Sales.Menu.Fact;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_menuFact {
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_COOK')")
    @GetMapping(value = "/menufact")
    public String menuplan(){
        return "menufact";
    }
}
