package Sales.Sales.Prodaji.Clients.getAvailableClients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/clients")
public class RC_getAvailableClients {
    @Autowired
    S_getAvailableClients getAvailableClients;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_CASHIER')")
    @GetMapping (value = "/getavailableclients")
    public List<String> getAvailableClients(){
        return getAvailableClients.getAvailableClients();
    }
 }
