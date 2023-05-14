package Sales.Sales.Sotrudniki.Profile;

import Sales.Sales.Sotrudniki.M_Sotrudniki;
import Sales.Sales.Sotrudniki.PayRequests.M_PaymentScheme;
import Sales.Sales.Sotrudniki.PayRequests.R_PaymentScheme;
import Sales.Sales.Sotrudniki.R_Sotrudniki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_requestPayment {
    @Autowired
    R_PaymentScheme RpaymentScheme;
    @Autowired
    R_Sotrudniki Rsotrudnik;
    public String requestpayment(DTO_requestPayment addpayment) {
        M_PaymentScheme payment=new M_PaymentScheme();
        M_Sotrudniki sotrudnik=Rsotrudnik.getBySotrudnikName(addpayment.getSotrudnikName());
        payment.setSotrudnik(sotrudnik);
        payment.setDate(addpayment.getDate());
        if(addpayment.sotrudnikPaymentBasic==0 && addpayment.sotrudnikPaymentExtra==0){
            return "nothing to add";
        }else {
            payment.setSotrudnikPaymentBasic(addpayment.sotrudnikPaymentBasic);
            payment.setSotrudnikPaymentExtra(addpayment.sotrudnikPaymentExtra);
            payment.setSotrudnikPaymentBasicStatus("requested");
            payment.setSotrudnikPaymentExtraStatus("requested");
            payment.setComment(addpayment.getComment());
            RpaymentScheme.save(payment);

            sotrudnik.setSotrudnikToBePayedBasic(sotrudnik.getSotrudnikToBePayedBasic()+addpayment.sotrudnikPaymentBasic);
            sotrudnik.setSotrudnikToBePayedExtra(sotrudnik.getSotrudnikToBePayedExtra()+addpayment.sotrudnikPaymentExtra);
            Rsotrudnik.save(sotrudnik);
            return "payment added";
        }
    }
}
