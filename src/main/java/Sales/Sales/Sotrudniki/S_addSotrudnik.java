package Sales.Sales.Sotrudniki;

import Sales.Sales.Base_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class S_addSotrudnik extends Base_Entity {
    @Autowired
    R_Sotrudniki Rsotrudnik;
    @Autowired
    R_Roles Rroles;
    @Autowired
    PasswordEncoder passwordEncoder;
    public String addsotrudnik(DTO_addSotrudnik addSotrudnik) {
        if(Rsotrudnik.getBySotrudnikName(addSotrudnik.sotrudnikname)==null){
            M_Sotrudniki sotrudnik=new M_Sotrudniki();
            sotrudnik.setSotrudnikName(addSotrudnik.sotrudnikname);
            sotrudnik.setSotrudnikPosition(addSotrudnik.sotrudnikposition);
            sotrudnik.setSotrudnikPassword(passwordEncoder.encode(addSotrudnik.password));
            List<M_Roles> Mroles=new ArrayList<>();
            M_Roles Mrole=Rroles.getByRole(addSotrudnik.sotrudnikrole);
            Mroles.add(Mrole);
            sotrudnik.setRoles(Mroles);
            Rsotrudnik.save(sotrudnik);
            return "added";
        }else{
            M_Sotrudniki sotrudnik=Rsotrudnik.getBySotrudnikName(addSotrudnik.sotrudnikname);
            if(!addSotrudnik.sotrudnikposition.equals("")){
                sotrudnik.setSotrudnikPosition(addSotrudnik.sotrudnikposition);
            }
            if(!addSotrudnik.sotrudnikrole.equals("")){
                List<M_Roles> Mroles=new ArrayList<>();
                M_Roles Mrole=Rroles.getByRole(addSotrudnik.sotrudnikrole);
                Mroles.add(Mrole);
                sotrudnik.setRoles(Mroles);
            }
            if(!addSotrudnik.password.equals("")){
                sotrudnik.setSotrudnikPassword(passwordEncoder.encode(addSotrudnik.password));
            }
            Rsotrudnik.save(sotrudnik);
            return "saved";
        }
    }
}
