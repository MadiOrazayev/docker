package Sales.Sales.Sotrudniki.PayRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTO_pay {
    public Long paymentid;
    public String basic;
    public String extra;
}
