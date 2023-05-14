package Sales.Sales.Proizvodstvo.Sklad;

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
@Table(name="sklad")
public class M_Sklad extends Base_Entity {
    String nazvanieProducta;
    private double ostatokNaSklade;
    private double srednyayaCena;
}
