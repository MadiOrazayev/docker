package Sales.Sales.Proizvodstvo.Sklad;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Sklad {
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_ZAKUP')")
    @GetMapping(value = "/sklad")
    public String sklad(){
        return "sklad";
    }
}
