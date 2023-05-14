package Sales.Sales.Prodaji.Cards.activateCard;

import Sales.Sales.Prodaji.Cards.M_Cards;
import Sales.Sales.Prodaji.Cards.R_Cards;
import Sales.Sales.Prodaji.Cards.cardsLog.S_saveToCardsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_activateCard {
    @Autowired
    R_Cards cardsRepository;

    @Autowired
    S_saveToCardsLog saveToCardsLog;

    public String activateCard(int cardNumber) {
        M_Cards card = cardsRepository.findByCardNumber(cardNumber);
        if (card == null) {
            return "card doesn't exist";
        } else {
            if (card.getCardStatus()!=null && card.getCardStatus().equals("active")) {
                return "card already active";
            } else {
                card.setCardStatus("active");
                card = cardsRepository.save(card);
                saveToCardsLog.save(card, "card activated");
                return "card activated";
            }
        }
    }
}
