package Sales.Sales.Prodaji.Clients.deactivateClient;

import Sales.Sales.Prodaji.Clients.M_Clients;
import Sales.Sales.Prodaji.Clients.R_Clients;
import Sales.Sales.Prodaji.Clients.clientsLog.S_saveToClientsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_deactivateClient {
    @Autowired
    R_Clients clientsRepository;

    @Autowired
    S_saveToClientsLog saveToClientsLog;

    public String deactivateClient(String clientName) {
        M_Clients client = clientsRepository.findByClientName(clientName);
        if (client == null) {
            return "client doesn't exists";
        } else {
            if (client.getClientStatus()!=null && client.getClientStatus().equals("deactive")) {
                return "client already deactive";
            } else {
                client.setClientStatus("deactive");
                client = clientsRepository.save(client);
                saveToClientsLog.save(client, "client deactivated");
                return "client deactivated";
            }
        }
    }
}
