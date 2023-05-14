package Sales.Sales.Prodaji.Clients.unassignCard;

import Sales.Sales.Prodaji.Cards.R_Cards;
import Sales.Sales.Prodaji.Clients.M_Clients;
import Sales.Sales.Prodaji.Clients.R_Clients;
import Sales.Sales.Prodaji.Clients.assignLog.S_saveToAssignLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_unassignCard {
    @Autowired
    R_Cards cardsRepository;
    @Autowired
    R_Clients clientsRepository;
    @Autowired
    S_saveToAssignLog saveToAssignLog;

    public String unassign(String clientName) {
        if (clientName.equals("")) {
            return "client entry empty";
        } else {
            M_Clients client = clientsRepository.findByClientName(clientName);
            if (client == null) {
                return "client doesn't exist";
            } else if (client.getCard() == null) {
                return "client doesn't have a card";
            } else {
                    saveToAssignLog.save(client.getCard(),client,"unassigned");
                    client.setCard(null);
                    clientsRepository.save(client);
                    return "card unassigned";
            }
        }
    }
}
