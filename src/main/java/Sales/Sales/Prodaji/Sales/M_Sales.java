package Sales.Sales.Prodaji.Sales;

import Sales.Sales.Base_Entity;
import Sales.Sales.Prodaji.Clients.M_Clients;
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
@Table(name="sales")
public class M_Sales extends Base_Entity {
    @OneToOne(fetch = FetchType.EAGER)
    M_Clients client;
    double revenueCard;
    double revenueKaspiCash;
    double tax;
    double cost;
    double profit;
    LocalDate date;
}
