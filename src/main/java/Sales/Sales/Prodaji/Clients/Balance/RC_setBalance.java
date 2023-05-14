package Sales.Sales.Prodaji.Clients.Balance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/setbalance")
public class RC_setBalance {
    @Autowired
    S_setBalance Sbalance;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PostMapping
    public String setBalance(@RequestBody int balance){
        return Sbalance.setBalance(balance);
    }
}
