package Sales.Sales.Sotrudniki.Profile;

import Sales.Sales.Sotrudniki.Profile.DTO_requestPayment;
import Sales.Sales.Sotrudniki.Profile.S_requestPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RC_requestPayment {
    @Autowired
    S_requestPayment Srequestpayment;
    @PreAuthorize("isAuthenticated()")
    @PostMapping(value="/addpayment")
    public String requestpayment(@RequestBody DTO_requestPayment addpayment) {
        return Srequestpayment.requestpayment(addpayment);
    }
   }
