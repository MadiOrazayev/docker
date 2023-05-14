package Sales.Sales.Prodaji.Clients.getAvailableClients;

import Sales.Sales.Prodaji.Clients.M_Clients;
import Sales.Sales.Prodaji.Clients.R_Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class S_getAvailableClients {
    @Autowired
    R_Clients clientsRepository;
    List<String> getAvailableClients(){
        List<String> availableClients=new ArrayList<>();
        List<M_Clients> clients=clientsRepository.findAll();
        for(M_Clients client:clients){
            if(client.getClientStatus()!=null && client.getClientStatus().equals("active")){
                if(client.getCard()==null){
                    availableClients.add(client.getClientName());
                }
            }
        }
        return availableClients;
    }
}
