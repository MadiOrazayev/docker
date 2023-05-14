package Sales.Sales.Prodaji.Clients.assignLog;

import Sales.Sales.Prodaji.Cards.M_Cards;
import Sales.Sales.Prodaji.Clients.M_Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_saveToAssignLog {
    @Autowired
    R_assignLog assignLogRepository;

    public void save(M_Cards card, M_Clients client, String action) {
        M_assignLog assignLog = new M_assignLog();
        assignLog.setCard(card);
        assignLog.setClient(client);
        assignLog.setAction(action);
        assignLog.setDate(java.time.LocalDate.now());
        assignLog.setTime(java.time.LocalTime.now());
        assignLogRepository.save(assignLog);
    }
}
