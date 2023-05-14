package Sales.Sales.Prodaji.Cards.cardsLog;

import Sales.Sales.Prodaji.Cards.M_Cards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_saveToCardsLog {
    @Autowired
    R_cardsLog cardsLogRepository;

    public void save(M_Cards card, String action) {
        M_cardsLog cardsLog = new M_cardsLog();
        cardsLog.setCard(card);
        cardsLog.setAction(action);
        cardsLog.setDate(java.time.LocalDate.now());
        cardsLog.setTime(java.time.LocalTime.now());
        cardsLogRepository.save(cardsLog);
    }
}
