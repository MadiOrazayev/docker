package Sales.Sales.Menu.Plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/addblyudo")
public class RC_addMenuItem {
    @Autowired
    S_addMenuItem addMenuItem;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_COOK')")
    @PostMapping
    public String addMenuItem(@RequestBody DTO_menuPlan menuitem) {
        return addMenuItem.addMenuItem(menuitem);
    }
}
