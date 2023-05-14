package Sales.Sales.Prodaji.Clients.addClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/clients")
public class RC_addClient {
    @Autowired
    S_addClient addClient;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_CASHIER')")
    @PostMapping(value = "/addclient")
    public String addClient(@RequestBody String clientName){
        return addClient.addClient(clientName);
    }
 }
