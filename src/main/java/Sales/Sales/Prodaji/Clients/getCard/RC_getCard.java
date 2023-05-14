package Sales.Sales.Prodaji.Clients.getCard;

import Sales.Sales.Prodaji.DTO_CardClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/clients")
public class RC_getCard {
    @Autowired
    S_getCard getCard;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_CASHIER')")
    @PostMapping(value = "/getcard")
    public DTO_CardClient getCard(@RequestBody  String clientName){
        return getCard.getCard(clientName);
    }
 }
