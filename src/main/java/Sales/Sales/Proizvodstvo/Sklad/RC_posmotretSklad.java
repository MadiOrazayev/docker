package Sales.Sales.Proizvodstvo.Sklad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(value = "/sklad")
public class RC_posmotretSklad {
    @Autowired
    S_posmotretSklad sklad;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_ZAKUP','ROLE_COOK')")//Nuzhno dlya calculyacii povaru
    @PostMapping(value = "/getproducts")
    public List<DTO_Sklad> getProducts(@RequestBody String inputdate)
    {
        System.out.println();
        LocalDate date=LocalDate.now();
        if(inputdate!="1900-01-01"){
            date = LocalDate.parse(inputdate);
        }
        return sklad.getProducts(date);
    }
}
