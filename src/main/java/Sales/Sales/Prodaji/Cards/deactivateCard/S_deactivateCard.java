package Sales.Sales.Prodaji.Cards.deactivateCard;

import Sales.Sales.Prodaji.Cards.M_Cards;
import Sales.Sales.Prodaji.Cards.R_Cards;
import Sales.Sales.Prodaji.Cards.cardsLog.S_saveToCardsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_deactivateCard {
    @Autowired
    R_Cards cardsRepository;

    @Autowired
    S_saveToCardsLog saveToCardsLog;

    public String deactivateCard(int cardNumber) {
        M_Cards card = cardsRepository.findByCardNumber(cardNumber);
        if (card == null) {
            return "card doesn't exists";
        } else {
            if (card.getCardStatus()!=null && card.getCardStatus().equals("deactive")) {
                return "card already deactive";
            } else {
                card.setCardStatus("deactive");
                card = cardsRepository.save(card);
                saveToCardsLog.save(card, "card deactivated");
                return "card deactivated";
            }
        }
    }
}
