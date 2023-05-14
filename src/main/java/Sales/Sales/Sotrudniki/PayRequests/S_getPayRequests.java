package Sales.Sales.Sotrudniki.PayRequests;

import Sales.Sales.Sotrudniki.M_Sotrudniki;
import Sales.Sales.Sotrudniki.PayRequests.DTO_paymentScheme;
import Sales.Sales.Sotrudniki.PayRequests.M_PaymentScheme;
import Sales.Sales.Sotrudniki.PayRequests.R_PaymentScheme;
import Sales.Sales.Sotrudniki.R_Sotrudniki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class S_getPayRequests {
    @Autowired
    R_PaymentScheme RpaymentScheme;
    @Autowired
    R_Sotrudniki Rsotrudnik;
    public List<DTO_paymentScheme> getpayrequests(String sotrudnikName) {
        M_Sotrudniki sotrudnik=Rsotrudnik.getBySotrudnikName(sotrudnikName);
        List<M_PaymentScheme> ListpaymentScheme=RpaymentScheme.findBySotrudnik(sotrudnik);
        List<DTO_paymentScheme> DTOpaymentschemeList=new ArrayList<>();
        for(M_PaymentScheme paymentScheme:ListpaymentScheme){
            int check=0;
            if(paymentScheme.getSotrudnikPaymentBasicStatus().equals("payed")){
                if(paymentScheme.getSotrudnikPaymentExtraStatus().equals("payed")){
                    check=1;
                }
            }
            if(check==0){
                DTO_paymentScheme DTOpaymentScheme=new DTO_paymentScheme();
                DTOpaymentScheme.setPaymentID(paymentScheme.getId());
                DTOpaymentScheme.setDate(paymentScheme.getDate());
                DTOpaymentScheme.setSotrudnikPaymentBasic(paymentScheme.getSotrudnikPaymentBasic());
                DTOpaymentScheme.setSotrudnikPaymentExtra(paymentScheme.getSotrudnikPaymentExtra());
                DTOpaymentScheme.setSotrudnikPaymentExtraStatus(paymentScheme.getSotrudnikPaymentExtraStatus());
                DTOpaymentScheme.setSotrudnikPaymentBasicStatus(paymentScheme.getSotrudnikPaymentBasicStatus());
                DTOpaymentScheme.setComment(paymentScheme.getComment());
                DTOpaymentschemeList.add(DTOpaymentScheme);
            }
        }
       return DTOpaymentschemeList;
    }
}
