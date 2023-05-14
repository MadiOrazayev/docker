package Sales.Sales.Sotrudniki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class S_Sotrudniki implements UserDetailsService {
    @Autowired
    R_Sotrudniki Rsotrudniki;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        M_Sotrudniki sotrudnik=Rsotrudniki.getBySotrudnikName(name);
        if(sotrudnik==null) throw new UsernameNotFoundException("User not found");
        return sotrudnik;
    }
}
