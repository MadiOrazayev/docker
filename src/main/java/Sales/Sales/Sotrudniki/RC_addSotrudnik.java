package Sales.Sales.Sotrudniki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RC_addSotrudnik {
    @Autowired
    S_addSotrudnik SaddSotrudnik;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PostMapping(value="/addsotrudnik")
    public String addsotrudnik(@RequestBody DTO_addSotrudnik addSotrudnik) {
        return SaddSotrudnik.addsotrudnik(addSotrudnik);
    }
}
