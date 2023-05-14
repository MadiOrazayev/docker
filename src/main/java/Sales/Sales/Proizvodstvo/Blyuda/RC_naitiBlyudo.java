package Sales.Sales.Proizvodstvo.Blyuda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value="/blyudo")
public class RC_naitiBlyudo {
    @Autowired
    S_naitiBlyudo SnaitiBlyudo;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_COOK')")
    @PostMapping(value = "/naiti")
    public DTOBlyudo naitiBlyudo(@RequestBody String nazvanieBlyuda) {
        return SnaitiBlyudo.naitiBlyudo(nazvanieBlyuda);
    }
}
