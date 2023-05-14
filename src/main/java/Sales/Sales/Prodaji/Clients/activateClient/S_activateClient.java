package Sales.Sales.Prodaji.Clients.activateClient;

import Sales.Sales.Prodaji.Clients.M_Clients;
import Sales.Sales.Prodaji.Clients.R_Clients;
import Sales.Sales.Prodaji.Clients.clientsLog.S_saveToClientsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_activateClient {
    @Autowired
    R_Clients clientsRepository;

    @Autowired
    S_saveToClientsLog saveToClientsLog;

    public String activateClient(String clientName) {
        M_Clients client = clientsRepository.findByClientName(clientName);
        if (client == null) {
            return "client doesn't exists";
        } else {
            if (client.getClientStatus()!=null && client.getClientStatus().equals("active")) {
                return "client already active";
            } else {
                client.setClientStatus("active");
                client = clientsRepository.save(client);
                saveToClientsLog.save(client, "client activated");
                return "client activated";
            }
        }
    }
}
