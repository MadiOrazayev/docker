package Sales.Sales.Proizvodstvo.Blyuda.Ceny;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Ceny {
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/ceny")
    public String prices(){
        return "ceny";
    }
}
