package Sales.Sales.Result;

import Sales.Sales.Menu.Fact.M_menuFact;
import Sales.Sales.Menu.Fact.R_menuFact;
import Sales.Sales.Prodaji.Sales.M_Sales;
import Sales.Sales.Prodaji.Sales.R_Sales;
import Sales.Sales.Sotrudniki.PayRequests.M_PaymentScheme;
import Sales.Sales.Sotrudniki.PayRequests.R_PaymentScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class S_Result {
    @Autowired
    R_Sales Rsales;
    @Autowired
    R_Result Rresult;
    @Autowired
    R_menuFact RmenuFact;
    @Autowired
    R_PaymentScheme RpaymentScheme;
    public List<DTO_Result> getResult(DTO_dates dates){
        List<DTO_Result> DTOresult=new ArrayList<>();
        LocalDate date=dates.startdate;
        while(date.isBefore(dates.enddate.plusDays(1))){
            if(Rresult.getByDate(date)==null){
            }else{
                Rresult.deleteByDate(date);
            }
            M_Result Mresult=new M_Result();
            List<M_Sales> Msales=Rsales.findByDate(date);
            for(M_Sales sales:Msales) {
                Mresult.setDohodCard(Mresult.getDohodCard() + sales.getRevenueCard());
                Mresult.setDohodKaspiNal(Mresult.getDohodKaspiNal() + sales.getRevenueKaspiCash());
                Mresult.setTax(Mresult.getTax() + sales.getTax());
                Mresult.setProducty(Mresult.getProducty() + sales.getCost());
            }
            List<M_menuFact> MmenuFact=RmenuFact.getByDate(date);
            if(MmenuFact!=null){
                for(M_menuFact menuFact:MmenuFact){
                    Mresult.setOstatki(Mresult.getOstatki()+menuFact.getItemLeft()*menuFact.getItemCost());
                }
            }
            Mresult.setArenda(0);
            Mresult.setZarplata(0);
            List<M_PaymentScheme> MpaymentScheme=RpaymentScheme.findByDate(date);
            if(MpaymentScheme!=null){
                for(M_PaymentScheme Mpayment:MpaymentScheme){
                    Mresult.setZarplata(Mresult.getZarplata()+Mpayment.getSotrudnikPaymentBasic()+Mpayment.getSotrudnikPaymentExtra());
                }
            }
            Mresult.setKommunalnye(0);
            Mresult.setProfit(Mresult.getDohodCard()+Mresult.getDohodKaspiNal()
            -Mresult.getProducty()-Mresult.getOstatki()-Mresult.getTax()
            -Mresult.getArenda()-Mresult.getZarplata()-Mresult.getKommunalnye());
            Mresult.setDate(date);
            Rresult.save(Mresult);

            DTO_Result result=new DTO_Result();
            result.setDohodCard(Mresult.getDohodCard());
            result.setDohodKaspiNal(Mresult.getDohodKaspiNal());
            result.setTax(Mresult.getTax());
            result.setProducty(Mresult.getProducty());
            result.setOstatki(Mresult.getOstatki());
            result.setArenda(Mresult.getArenda());
            result.setZarplata(Mresult.getZarplata());
            result.setKommunalnye(Mresult.getKommunalnye());
            result.setProfit(Mresult.getProfit());
            result.setDate(Mresult.getDate());
            DTOresult.add(result);
            date=date.plusDays(1);
        }
        return DTOresult;
    }
}
