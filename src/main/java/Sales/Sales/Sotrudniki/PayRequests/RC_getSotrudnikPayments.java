package Sales.Sales.Sotrudniki.PayRequests;

import Sales.Sales.Sotrudniki.DTO_Sotrudnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RC_getSotrudnikPayments {
    @Autowired
    S_getSotrudnikPayments Sgetsotrudnikpayments;
    @PreAuthorize("isAuthenticated()")
    @PostMapping(value="/getsotrudnikpayments")
    public DTO_Sotrudnik getSotrudnikPayments(@RequestBody String sotrudnikName) {
        return Sgetsotrudnikpayments.getSotrudnikPayments(sotrudnikName);
    }
}
