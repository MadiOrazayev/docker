package Sales.Sales.Sotrudniki.PayRequests;

import Sales.Sales.Sotrudniki.M_Sotrudniki;
import Sales.Sales.Sotrudniki.R_Sotrudniki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class S_pay {
    @Autowired
    R_PaymentScheme RpaymentScheme;
    @Autowired
    R_Sotrudniki Rsotrudniki;
    public String pay(@RequestBody List<DTO_pay> pays) {
        for(DTO_pay pay:pays){
            M_PaymentScheme paymentScheme=RpaymentScheme.findById(pay.paymentid).orElseThrow();
            M_Sotrudniki sotrudnik=paymentScheme.getSotrudnik();
            if(paymentScheme.getSotrudnikPaymentBasicStatus().equals("requested")){
                if(pay.getBasic().equals("payed")){
                    paymentScheme.setSotrudnikPaymentBasicStatus(pay.getBasic());
                    sotrudnik.setSotrudnikToBePayedBasic(sotrudnik.getSotrudnikToBePayedBasic()-paymentScheme.getSotrudnikPaymentBasic());
                    sotrudnik.setSotrudnikPayedBasic(sotrudnik.getSotrudnikPayedBasic()+paymentScheme.getSotrudnikPaymentBasic());
                    RpaymentScheme.save(paymentScheme);
                    Rsotrudniki.save(sotrudnik);
                }
            }

            paymentScheme=RpaymentScheme.findById(pay.paymentid).orElseThrow();
            sotrudnik=paymentScheme.getSotrudnik();
            if(paymentScheme.getSotrudnikPaymentExtraStatus().equals("requested")){
                if(pay.getExtra().equals("payed")){
                    paymentScheme.setSotrudnikPaymentExtraStatus(pay.getExtra());
                    sotrudnik.setSotrudnikToBePayedExtra(sotrudnik.getSotrudnikToBePayedExtra()-paymentScheme.getSotrudnikPaymentExtra());
                    sotrudnik.setSotrudnikPayedExtra(sotrudnik.getSotrudnikPayedExtra()+paymentScheme.getSotrudnikPaymentExtra());
                    RpaymentScheme.save(paymentScheme);
                    Rsotrudniki.save(sotrudnik);
                }
            }
        }
       return "saved";
    }
}
