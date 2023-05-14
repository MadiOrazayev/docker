package Sales.Sales.Sotrudniki.PayRequests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RC_pay {
    @Autowired
    S_pay Spay;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PostMapping(value="/pay")
    public String pay(@RequestBody List<DTO_pay> pays) {
        return Spay.pay(pays);
    }
}
