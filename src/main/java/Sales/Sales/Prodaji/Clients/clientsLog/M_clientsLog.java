package Sales.Sales.Prodaji.Clients.clientsLog;

import Sales.Sales.Prodaji.Clients.M_Clients;
import Sales.Sales.Base_Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name="clients_log")
public class M_clientsLog extends Base_Entity {
    @OneToOne(fetch = FetchType.EAGER)
    private M_Clients client;
    private String action;
    private LocalDate date;
    private LocalTime time;
}
