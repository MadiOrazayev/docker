package Sales.Sales.Prodaji.Cards.addCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/cards")
public class RC_addCard {
    @Autowired
    S_addCard addCard;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_CASHIER')")
    @PostMapping(value = "/addcard")
    public String addCard(@RequestBody int cardNumber){
        return addCard.addCard(cardNumber);
    }
 }
