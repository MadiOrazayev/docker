package Sales.Sales.Menu.Plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/savemenuplan")
public class RC_saveMenuPlan {
    @Autowired
    S_saveMenuPlan SsaveMenuPlan;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_COOK')")
    @PostMapping
    public String saveMenuPlan(@RequestBody List<DTO_menuPlan> DTOmenuPlan) {
        return SsaveMenuPlan.saveMenuPlan(DTOmenuPlan);
    }
}
