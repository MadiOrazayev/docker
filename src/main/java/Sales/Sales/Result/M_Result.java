package Sales.Sales.Result;

import Sales.Sales.Base_Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="result")
public class M_Result extends Base_Entity {
    LocalDate date;
    double dohodCard;
    double dohodKaspiNal;
    double tax;
    double producty;
    double ostatki;
    double zarplata;
    double arenda;
    double kommunalnye;
    double profit;
}
