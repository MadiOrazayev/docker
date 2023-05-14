package Sales.Sales.Proizvodstvo.Blyuda.Ceny;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/ceny")
public class RC_sohranitCeny {
    @Autowired
    S_sohranitCeny SsohranitCeny;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/sohranit")
    public String sohranit(@RequestBody List<DTOCeny> DTOceny){
        return SsohranitCeny.sohranitCeny(DTOceny);
    }
}
