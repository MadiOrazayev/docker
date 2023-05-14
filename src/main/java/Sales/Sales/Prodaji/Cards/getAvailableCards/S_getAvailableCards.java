package Sales.Sales.Prodaji.Cards.getAvailableCards;

import Sales.Sales.Prodaji.Cards.M_Cards;
import Sales.Sales.Prodaji.Cards.R_Cards;
import Sales.Sales.Prodaji.Clients.R_Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class S_getAvailableCards {
    @Autowired
    R_Clients clientsRepository;
    @Autowired
    R_Cards cardsRepository;
    List<Integer> getAvailableCards(){
        List<Integer> availableCards=new ArrayList<>();
        List<M_Cards> cards=cardsRepository.findAll();
        for(M_Cards card:cards){
            if(card.getCardStatus()!=null && card.getCardStatus().equals("active")){
                if(clientsRepository.findByCard(card)==null){
                    availableCards.add(card.getCardNumber());
                }
            }
        }
        return availableCards;
    }
}
