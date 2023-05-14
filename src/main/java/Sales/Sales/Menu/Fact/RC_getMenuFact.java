package Sales.Sales.Menu.Fact;

import Sales.Sales.Menu.Plan.DTO_menuPlan;
import Sales.Sales.Menu.Plan.S_getMenuPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(value="/getmenufact")
public class RC_getMenuFact {
    @Autowired
    S_getMenuFact getMenuFact;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_COOK','ROLE_CASHIER')")//Nuhno kassiru dlya prodaj
    @PostMapping
    public List<DTO_menuFact> getMenuFact(@RequestBody String inputdate) {
        LocalDate date=LocalDate.now();
        if(!inputdate.equals("1900-01-01")){
            date = LocalDate.parse(inputdate);
        }
        return getMenuFact.getMenuFact(date);
    }
}
