package Sales.Sales.Sotrudniki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RC_Roles {
    @Autowired
    R_Roles Rroles;
    @GetMapping(value = "/getrolelist")
    public List<DTO_Roles> getRoles(Model model){
       List<M_Roles> Mroles=Rroles.findAll();
       List<DTO_Roles> roles=new ArrayList<>();
       for(M_Roles Mrole:Mroles){
           DTO_Roles role=new DTO_Roles();
           role.setRole(Mrole.getRole());
           roles.add(role);
       }
       return roles;
    }
}
