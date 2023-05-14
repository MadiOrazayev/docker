package Sales.Sales.Prodaji.Sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/saleshistory")
public class RC_Sales_History {
    @Autowired
    S_Sales_History Ssales;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_CASHIER')")
    @PostMapping(value = "/save")
    public String saveSales(@RequestBody DTO_Sales_History sales){
        return Ssales.save(sales);
    }
}
