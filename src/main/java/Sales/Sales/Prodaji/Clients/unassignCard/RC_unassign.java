package Sales.Sales.Prodaji.Clients.unassignCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/clients")
public class RC_unassign {
    @Autowired
    S_unassignCard unassignCard;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_CASHIER')")
    @PostMapping(value = "/unassigncard")
    public String assignCard(@RequestBody String clientName){
        return unassignCard.unassign(clientName);
    }
}
