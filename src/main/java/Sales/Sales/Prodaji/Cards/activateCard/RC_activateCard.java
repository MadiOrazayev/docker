package Sales.Sales.Prodaji.Cards.activateCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/cards")
public class RC_activateCard {
    @Autowired
    S_activateCard activateCard;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_CASHIER')")
    @PostMapping(value = "/activatecard")
    public String activateCard(@RequestBody int cardNumber){
        return activateCard.activateCard(cardNumber);
    }
 }
