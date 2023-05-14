package Sales.Sales.Prodaji.Clients;

import Sales.Sales.Base_Entity;
import Sales.Sales.Prodaji.Cards.M_Cards;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="clients")
public class M_Clients extends Base_Entity {
    private String clientName;
    private String clientStatus;
    @OneToOne(fetch = FetchType.EAGER)
    private M_Cards card;
    int balance;
}
