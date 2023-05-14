package Sales.Sales.Menu.Fact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@RequestMapping(value="/savemenufact")
public class RC_saveMenuFact {
    @Autowired
    S_saveMenuFact saveMenuFact;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_COOK')")
    @PostMapping
    public String saveMenuFact(@RequestBody String inputdate) {
        LocalDate date=LocalDate.parse(inputdate);
        return saveMenuFact.saveMenuFact(date);
    }
}
