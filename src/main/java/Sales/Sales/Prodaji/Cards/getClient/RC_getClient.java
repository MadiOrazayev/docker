package Sales.Sales.Prodaji.Cards.getClient;

import Sales.Sales.Prodaji.DTO_CardClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/cards")
public class RC_getClient {
    @Autowired
    S_getClient getClient;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_CASHIER')")
    @PostMapping(value = "/getclient")
    public DTO_CardClient getClient(@RequestBody  int cardNumber){
        return getClient.getClient(cardNumber);
    }
}
