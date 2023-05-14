package Sales.Sales.Prodaji.Sales;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Sales_History {
    String clientName;
    List<DTO_Sales_History_Blyuda> blyuda;
    double rev_card;
    double rev_kaspi_cash;
}
