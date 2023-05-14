package Sales.Sales.Prodaji.Sales;

import Sales.Sales.Base_Entity;
import Sales.Sales.Prodaji.Clients.M_Clients;
import Sales.Sales.Proizvodstvo.Blyuda.M_Blyuda;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name="sales_history")
public class M_Sales_History extends Base_Entity {
    @OneToOne(fetch = FetchType.EAGER)
    M_Clients client;
    @OneToOne(fetch = FetchType.EAGER)
    M_Blyuda blyudo;
    double sebes;
    double porciyi;
    double price;
    double profit;
    LocalTime time;
    LocalDate date;
}
