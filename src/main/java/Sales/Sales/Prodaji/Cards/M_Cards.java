package Sales.Sales.Prodaji.Cards;

import Sales.Sales.Base_Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="cards")
public class M_Cards extends Base_Entity {
    private int cardNumber;
    private String cardStatus;
}
