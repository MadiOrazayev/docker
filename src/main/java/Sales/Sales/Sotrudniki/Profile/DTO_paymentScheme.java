package Sales.Sales.Sotrudniki.Profile;

import Sales.Sales.Sotrudniki.M_Sotrudniki;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTO_paymentScheme {
    public LocalDate date;
    public double sotrudnikPaymentBasic;
    public double sotrudnikPaymentExtra;
    public String sotrudnikPaymentBasicStatus;
    public String sotrudnikPaymentExtraStatus;
    public String comment;
}
