package Sales.Sales.Sotrudniki.Profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTO_requestPayment {
    String sotrudnikName;
    LocalDate date;
    double sotrudnikPaymentBasic;
    double sotrudnikPaymentExtra;
    String comment;
}
