package Sales.Sales.Proizvodstvo.Blyuda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/blyuda")
public class RC_spisokBlyud {
    @Autowired
    S_spisokBlyud SspisokBlyud;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_COOK')")
    @GetMapping(value = "/spisok")
    public List<String> spisokBlyud() {
        return SspisokBlyud.spisokBlyud();
    }
}
