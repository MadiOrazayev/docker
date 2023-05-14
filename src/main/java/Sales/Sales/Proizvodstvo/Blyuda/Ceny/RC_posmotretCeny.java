package Sales.Sales.Proizvodstvo.Blyuda.Ceny;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/ceny")
public class RC_posmotretCeny {
    @Autowired
    S_posmotretCeny SposmotretCeny;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/posmotret")
    public List<DTOCeny> posmotret(){
        return SposmotretCeny.posmotretCeny();
    }
}
