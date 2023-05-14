package Sales.Sales.Menu.Plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(value="/getmenuplan")
public class RC_getMenuPlan {
    @Autowired
    S_getMenuPlan getMenuPlan;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_COOK')")
    @PostMapping
    public List<DTO_menuPlan> getMenuPlan(@RequestBody String inputdate) {
        LocalDate date=LocalDate.parse(inputdate);
        return getMenuPlan.getMenuPlan(date);
    }
}
