package Sales.Sales.Prodaji.Clients.activateClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/clients")
public class RC_activateClient {
    @Autowired
    S_activateClient activateClient;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_CASHIER')")
    @PostMapping(value = "/activateclient")
    public String activateClient(@RequestBody String clientName){
        return activateClient.activateClient(clientName);
    }
 }
