package Sales.Sales.Prodaji.Clients.Balance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/getbalance")
public class RC_getBalance {
    @Autowired
    S_getBalance Sbalance;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_CASHIER')")
    @PostMapping
    public int getBalance(@RequestBody String clientName){
        return Sbalance.getBalance(clientName);
    }
}
