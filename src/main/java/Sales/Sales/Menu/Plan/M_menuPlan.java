package Sales.Sales.Menu.Plan;

import Sales.Sales.Proizvodstvo.Blyuda.M_Blyuda;
import Sales.Sales.Base_Entity;
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
@Table(name="menu_plan")
public class M_menuPlan extends Base_Entity {
    @OneToOne(fetch = FetchType.EAGER)
    M_Blyuda blyudo;
    LocalDate date;
    double kolichestvoPorciy;
}
