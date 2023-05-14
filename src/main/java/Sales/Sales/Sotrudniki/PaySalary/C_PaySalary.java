package Sales.Sales.Sotrudniki.PaySalary;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_PaySalary {
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/paysalary")
    public String profile() {
        return "paysalary";
    }
}
