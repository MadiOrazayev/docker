package Sales.Sales.Sotrudniki.PayRequests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RC_getPayRequests {
    @Autowired
    S_getPayRequests Sgetpayrequests;
    @PreAuthorize("isAuthenticated()")
    @PostMapping(value="/getpayrequests")
    public List<DTO_paymentScheme> getpayrequests(@RequestBody String sotrudnikName) {
        return Sgetpayrequests.getpayrequests(sotrudnikName);
    }
}
