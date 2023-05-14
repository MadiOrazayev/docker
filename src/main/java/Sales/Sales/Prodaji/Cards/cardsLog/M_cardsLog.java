package Sales.Sales.Prodaji.Cards.cardsLog;

import Sales.Sales.Prodaji.Cards.M_Cards;
import Sales.Sales.Base_Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name="cards_log")
public class M_cardsLog extends Base_Entity {
    @OneToOne(fetch = FetchType.EAGER)
    private M_Cards card;
    private String action;
    private LocalDate date;
    private LocalTime time;
}
