package Sales.Sales.Sotrudniki;

import Sales.Sales.Base_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class S_editSotrudnik extends Base_Entity {
    @Autowired
    R_Sotrudniki Rsotrudnik;
    public String editsotrudnik(DTO_editSotrudnik editSotrudnik) {
        M_Sotrudniki sotrudnik=Rsotrudnik.getBySotrudnikName(editSotrudnik.getSotrudnikName());
        sotrudnik.setSotrudnikContact(editSotrudnik.getSotrudnikContact());
        sotrudnik.setKaspi(editSotrudnik.getKaspiContact());
        Rsotrudnik.save(sotrudnik);
        return "updated";
    }
}
