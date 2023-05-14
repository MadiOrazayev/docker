package Sales.Sales.Sotrudniki.PaySalary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RC_getSotrudnikList {
    @Autowired
    S_getSotrudnikList Sgetsotrudniklist;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PostMapping(value="/getsotrudniklist")
    public List<DTO_SotrudnikList> getSotrudnikList() {
        return Sgetsotrudniklist.getSotrudnikList();
    }
}
