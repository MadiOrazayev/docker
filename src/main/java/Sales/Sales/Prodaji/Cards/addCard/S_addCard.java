package Sales.Sales.Prodaji.Cards.addCard;

import Sales.Sales.Prodaji.Cards.M_Cards;
import Sales.Sales.Prodaji.Cards.R_Cards;
import Sales.Sales.Prodaji.Cards.cardsLog.S_saveToCardsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_addCard {
    @Autowired
    R_Cards cardsRepository;

    @Autowired
    S_saveToCardsLog saveToCardsLog;

    public String addCard(int cardNumber) {
        M_Cards card = cardsRepository.findByCardNumber(cardNumber);
        if(card!=null){
            return "card already exists";
        }else{
            card = new M_Cards();
            card.setCardNumber(cardNumber);
            card = cardsRepository.save(card);
            saveToCardsLog.save(card,"card added");
            return "card added";
        }
    }
}
