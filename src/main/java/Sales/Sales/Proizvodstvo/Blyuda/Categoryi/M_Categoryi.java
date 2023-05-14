package Sales.Sales.Proizvodstvo.Blyuda.Categoryi;

import Sales.Sales.Base_Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="categoryi")
public class M_Categoryi extends Base_Entity {
    String categoriyaBlyuda;
}
