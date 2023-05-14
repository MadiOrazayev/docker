package Sales.Sales.Prodaji.Clients.addClient;

import Sales.Sales.Prodaji.Clients.R_Clients;
import Sales.Sales.Prodaji.Clients.clientsLog.S_saveToClientsLog;
import Sales.Sales.Prodaji.Clients.M_Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_addClient {
    @Autowired
    R_Clients clientsRepository;

    @Autowired
    S_saveToClientsLog saveToClientsLog;

    public String addClient(String clientName) {
        M_Clients client = clientsRepository.findByClientName(clientName);
        if(client!=null){
            return "client already exists";
        }else{
            client = new M_Clients();
            client.setClientName(clientName);
            client = clientsRepository.save(client);
            saveToClientsLog.save(client,"client added");
            return "client added";
        }
    }
}
