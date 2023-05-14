package Sales.Sales.Result;

import Sales.Sales.Prodaji.Sales.DTO_Sales_History;
import Sales.Sales.Prodaji.Sales.S_Sales_History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value="/getresult")
public class RC_Result {
    @Autowired
    S_Result Sresult;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PostMapping
    public List<DTO_Result> getresult(@RequestBody DTO_dates dates){
        return Sresult.getResult(dates);
    }
}
