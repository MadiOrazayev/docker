package Sales.Sales.Proizvodstvo.Blyuda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/blyudo")
public class RC_sohranitBlyudo {
    @Autowired
    S_sohranitBlyudo SsohranitBlyudo;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_COOK')")
    @PostMapping(value = "/sohranit")
    public String sohranit(@RequestBody DTOBlyudo DTOblyudo){
        return SsohranitBlyudo.sohranitBlyudo(DTOblyudo);
    }
}
