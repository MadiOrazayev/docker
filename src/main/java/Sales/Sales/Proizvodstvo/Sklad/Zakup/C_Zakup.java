package Sales.Sales.Proizvodstvo.Sklad.Zakup;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Zakup {
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_ZAKUP')")
    @GetMapping(value = "/zakup")
    public String zakup(){
        return "zakup";
    }
}
