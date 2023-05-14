package Sales.Sales.Menu.Fact;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DTO_menuFact {
    String itemName;
    String itemCategory;
    double itemPrice;
    double itemSold;
    double itemLeft;
    double itemCost;
    double itemAmount;
    LocalDate date;
}
