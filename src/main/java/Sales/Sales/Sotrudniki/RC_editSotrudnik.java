package Sales.Sales.Sotrudniki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RC_editSotrudnik {
    @Autowired
    S_editSotrudnik SeditSotrudnik;
    @PreAuthorize("isAuthenticated()")
    @PostMapping(value="/editsotrudnik")
    public String editsotrudnik(@RequestBody DTO_editSotrudnik editSotrudnik) {
        return SeditSotrudnik.editsotrudnik(editSotrudnik);
    }
}
