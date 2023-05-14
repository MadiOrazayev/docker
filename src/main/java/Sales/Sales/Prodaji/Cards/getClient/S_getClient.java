package Sales.Sales.Prodaji.Cards.getClient;

import Sales.Sales.Prodaji.Cards.M_Cards;
import Sales.Sales.Prodaji.Cards.R_Cards;
import Sales.Sales.Prodaji.Clients.M_Clients;
import Sales.Sales.Prodaji.Clients.R_Clients;
import Sales.Sales.Prodaji.DTO_CardClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_getClient {
    @Autowired
    R_Clients clientsRepository;
    @Autowired
    R_Cards cardsRepository;

    DTO_CardClient getClient(int cardNumber) {
        DTO_CardClient cardClient = new DTO_CardClient();
        M_Cards card=cardsRepository.findByCardNumber(cardNumber);
        if (card != null) {
            cardClient.setCardNumber(cardNumber);
            if(card.getCardStatus()!=null) {
                cardClient.setCardStatus(card.getCardStatus());
            }
            M_Clients client=clientsRepository.findByCard(card);
            if (client != null) {
                cardClient.setClientName(client.getClientName());
                if (client.getClientStatus() != null) {
                    cardClient.setClientStatus(client.getClientStatus());
                    cardClient.setBalance(client.getBalance());
                }
            }
        }
        return cardClient;
    }
}
