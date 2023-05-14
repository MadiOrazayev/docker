package Sales.Sales.Prodaji.Clients.clientsLog;

import Sales.Sales.Prodaji.Clients.M_Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_saveToClientsLog {
    @Autowired
    R_clientsLog clientsLogRepository;

    public void save(M_Clients client, String action) {
        M_clientsLog clientsLog = new M_clientsLog();
        clientsLog.setClient(client);
        clientsLog.setAction(action);
        clientsLog.setDate(java.time.LocalDate.now());
        clientsLog.setTime(java.time.LocalTime.now());
        clientsLogRepository.save(clientsLog);
    }
}
