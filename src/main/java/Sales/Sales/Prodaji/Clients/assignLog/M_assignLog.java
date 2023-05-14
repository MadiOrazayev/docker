package Sales.Sales.Prodaji.Clients.assignLog;

import Sales.Sales.Prodaji.Clients.M_Clients;
import Sales.Sales.Base_Entity;
import Sales.Sales.Prodaji.Cards.M_Cards;
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
@Table(name="assign_log")
public class M_assignLog extends Base_Entity {
    @OneToOne(fetch = FetchType.EAGER)
    private M_Clients client;
    @OneToOne(fetch = FetchType.EAGER)
    private M_Cards card;
    private String action;
    private LocalDate date;
    private LocalTime time;
}
