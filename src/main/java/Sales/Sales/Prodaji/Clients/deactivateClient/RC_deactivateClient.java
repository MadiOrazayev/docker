package Sales.Sales.Prodaji.Clients.deactivateClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/clients")
public class RC_deactivateClient {
    @Autowired
    S_deactivateClient deactivateClient;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_CASHIER')")
    @PostMapping(value = "/deactivateclient")
    public String deactivateClient(@RequestBody String clientName){
        return deactivateClient.deactivateClient(clientName);
    }
 }
