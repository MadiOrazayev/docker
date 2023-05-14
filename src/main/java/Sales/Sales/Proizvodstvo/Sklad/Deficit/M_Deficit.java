package Sales.Sales.Proizvodstvo.Sklad.Deficit;

import Sales.Sales.Base_Entity;
import Sales.Sales.Proizvodstvo.Sklad.M_Sklad;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="deficit")
public class M_Deficit extends Base_Entity {
    @OneToOne(fetch = FetchType.EAGER)
    M_Sklad product;
    double deficit;
    LocalDate date;
}
