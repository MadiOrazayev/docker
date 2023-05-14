package Sales.Sales.Prodaji.Clients.assignCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/clients")
public class RC_assign {
    @Autowired
    S_assignCard assignCard;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_CASHIER')")
    @PostMapping(value = "/assigncard")
    public String assignCard(@RequestBody DTO_assign assign){
        return assignCard.assign(assign);
    }
}
