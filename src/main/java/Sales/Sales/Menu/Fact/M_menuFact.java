package Sales.Sales.Menu.Fact;

import Sales.Sales.Base_Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="menu_fact")
public class M_menuFact extends Base_Entity {
    String itemName;
    String itemCategory;
    double itemPrice;
    double itemSold;
    double itemLeft;
    double itemCost;
    double itemAmount;
    LocalDate date;
}
