package Sales.Sales.Proizvodstvo.Blyuda.Sostav;

import Sales.Sales.Proizvodstvo.Blyuda.M_Blyuda;
import Sales.Sales.Base_Entity;
import Sales.Sales.Proizvodstvo.Sklad.M_Sklad;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "sostav")
public class M_Sostav extends Base_Entity {
    @OneToOne(fetch = FetchType.EAGER)
    M_Blyuda blyudo;
    @OneToOne(fetch = FetchType.EAGER)
    M_Sklad product;
    double kolichestvoProducta;
}
