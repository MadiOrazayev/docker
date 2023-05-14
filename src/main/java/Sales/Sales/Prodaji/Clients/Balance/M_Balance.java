package Sales.Sales.Prodaji.Clients.Balance;

import Sales.Sales.Base_Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="balance")
public class M_Balance extends Base_Entity {
    private int balance;
}