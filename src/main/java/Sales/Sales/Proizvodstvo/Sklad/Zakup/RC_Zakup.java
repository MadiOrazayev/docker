package Sales.Sales.Proizvodstvo.Sklad.Zakup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/zakup")
public class RC_Zakup {
    @Autowired
    S_Zakup Szakup;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_ZAKUP')")
    @PostMapping(value = "/zakupit")
    public String addZakup(@RequestBody List<DTO_Zakup> DTOzakup) {
        return Szakup.addZakup(DTOzakup);
    }
}
