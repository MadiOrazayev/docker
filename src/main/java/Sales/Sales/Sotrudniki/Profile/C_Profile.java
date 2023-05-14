package Sales.Sales.Sotrudniki.Profile;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Profile {
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profile() {
        return "profile";
    }
}
