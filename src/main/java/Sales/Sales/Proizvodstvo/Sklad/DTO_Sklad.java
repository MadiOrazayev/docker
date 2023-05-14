package Sales.Sales.Proizvodstvo.Sklad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Sklad {
    String productName;
    private double productLeft;
    private double productDeficit;
    private double productAvPrice;
}
