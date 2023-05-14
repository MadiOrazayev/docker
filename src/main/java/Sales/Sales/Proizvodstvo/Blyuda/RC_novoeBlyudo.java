package Sales.Sales.Proizvodstvo.Blyuda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/blyudo")
public class RC_novoeBlyudo {
    @Autowired
    S_novoeBlyudo SnovoeBlyudo;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_COOK')")
    @PostMapping(value = "/novoeBlyudo")
    String novoeBlyudo(@RequestBody DTOBlyudo DTOblyudo){
        return SnovoeBlyudo.novoeBlyudo(DTOblyudo);
    }
}
