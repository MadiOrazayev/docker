package Sales.Sales.Prodaji.Clients.assignCard;

import Sales.Sales.Prodaji.Cards.R_Cards;
import Sales.Sales.Prodaji.Cards.M_Cards;
import Sales.Sales.Prodaji.Clients.assignLog.S_saveToAssignLog;
import Sales.Sales.Prodaji.Clients.M_Clients;
import Sales.Sales.Prodaji.Clients.R_Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class S_assignCard {
    @Autowired
    R_Cards cardsRepository;
    @Autowired
    R_Clients clientsRepository;
    @Autowired
    S_saveToAssignLog saveToAssignLog;

    public String assign(DTO_assign assign) {
        if (assign.getClientName().equals("")) {
            return "client entry empty";
        } else if (assign.getCardNumber() == 0) {
            return "card entry is zero";
        } else {
            M_Clients client = clientsRepository.findByClientName(assign.getClientName());
            if (client == null) {
                return "client doesn't exist";
            } else if (client.getCard() != null) {
                return "client already has a card";
            } else {
                M_Cards card = cardsRepository.findByCardNumber(assign.getCardNumber());
                if (card == null) {
                    return "card doesn't exist";
                } else if (clientsRepository.findByCard(card) != null) {
                    return "card already assigned";
                } else {
                    client.setCard(card);
                    clientsRepository.save(client);
                    saveToAssignLog.save(card,client,"assigned");
                    return "card assigned";
                }
            }
        }
    }
}
