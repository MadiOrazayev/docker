package Sales.Sales.Prodaji.Clients.getCard;

import Sales.Sales.Prodaji.Clients.M_Clients;
import Sales.Sales.Prodaji.Clients.R_Clients;
import Sales.Sales.Prodaji.DTO_CardClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_getCard {
    @Autowired
    R_Clients clientsRepository;
    DTO_CardClient getCard(String clientName){
        DTO_CardClient cardClient=new DTO_CardClient();
        M_Clients client=clientsRepository.findByClientName(clientName);
        if(client!=null){
            cardClient.setClientName(clientName);
            if(client.getClientStatus()!=null){
                cardClient.setClientStatus(client.getClientStatus());
                cardClient.setBalance(client.getBalance());
            }
            if(client.getCard()!=null){
                cardClient.setCardNumber(client.getCard().getCardNumber());
                cardClient.setCardStatus(client.getCard().getCardStatus());
            }
        }
        return cardClient;
    }
}


