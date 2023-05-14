package Sales.Sales.Sotrudniki.PayRequests;

import Sales.Sales.Base_Entity;
import Sales.Sales.Sotrudniki.M_Sotrudniki;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="sotrudnikpaymentscheme")
@Getter
@Setter
public class M_PaymentScheme extends Base_Entity {
    @OneToOne(fetch = FetchType.EAGER)
    M_Sotrudniki sotrudnik;
    private LocalDate date;
    private double sotrudnikPaymentBasic;
    private double sotrudnikPaymentExtra;
    private String sotrudnikPaymentBasicStatus;
    private String sotrudnikPaymentExtraStatus;
    private String comment;
}
