package Sales.Sales.Proizvodstvo.Blyuda;

import Sales.Sales.Base_Entity;
import Sales.Sales.Proizvodstvo.Blyuda.Categoryi.M_Categoryi;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="blyuda")
public class M_Blyuda extends Base_Entity {
    String nazvanieBlyuda;
    @OneToOne(fetch = FetchType.EAGER)
    M_Categoryi categoriyaBlyuda;
    double cenaBlyuda;
    double sebestoimostBlyuda;
}
