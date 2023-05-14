package Sales.Sales.Prodaji.Cards.deactivateCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/cards")
public class RC_deactivateCard {
    @Autowired
    S_deactivateCard deactivateCard;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_CASHIER')")
    @PostMapping(value = "/deactivatecard")
    public String deactivateCard(@RequestBody int cardNumber){
        return deactivateCard.deactivateCard(cardNumber);
    }
 }
