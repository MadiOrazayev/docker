package Sales.Sales.Proizvodstvo.Blyuda;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Blyuda {
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_COOK')")
    @GetMapping(value = "/blyuda")
    public String prices(){
        return "blyuda";
    }
}
