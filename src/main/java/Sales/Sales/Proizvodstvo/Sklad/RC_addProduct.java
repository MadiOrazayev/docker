package Sales.Sales.Proizvodstvo.Sklad;

import Sales.Sales.Proizvodstvo.Sklad.Zakup.S_Zakup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/sklad")
public class RC_addProduct {
    @Autowired
    S_addProduct SaddProduct;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_ZAKUP')")
    @PostMapping(value = "/addproduct")
    public String addProduct(@RequestBody String productName) {
        return SaddProduct.addProduct(productName);
    }
}
