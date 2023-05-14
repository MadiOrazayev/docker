package Sales.Sales.Prodaji.Cards.getAvailableCards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/cards")
public class RC_getAvailableCards {
    @Autowired
    S_getAvailableCards getAvailableCards;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_CASHIER')")
    @GetMapping (value = "/getavailablecards")
    public List<Integer> getAvailableCards(){
        return getAvailableCards.getAvailableCards();
    }
 }
