package Sales.Sales.Proizvodstvo.Sklad.Deficit;

import Sales.Sales.Menu.Plan.R_menuPlan;
import Sales.Sales.Proizvodstvo.Blyuda.Sostav.M_Sostav;
import Sales.Sales.Proizvodstvo.Blyuda.Sostav.R_Sostav;
import Sales.Sales.Menu.Plan.M_menuPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class S_calcDeficit {
    @Autowired
    R_menuPlan RmenuPlan;
    @Autowired
    R_Sostav Rsostav;
    @Autowired
    R_Deficit Rdeficit;
    public void calcDeficit(LocalDate date){
        Rdeficit.deleteByDate(date);
        for(M_menuPlan menuPlanItem:RmenuPlan.getByDate(date)){
            for(M_Sostav sostav:Rsostav.getByBlyudo(menuPlanItem.getBlyudo())){
                M_Deficit deficit=Rdeficit.findByProductAndDate(sostav.getProduct(),date);
                if(deficit==null){
                    deficit=new M_Deficit();
                    deficit.setDate(date);
                    deficit.setProduct(sostav.getProduct());
                    deficit.setDeficit(0);
                }
                deficit.setDeficit(deficit.deficit+
                        (sostav.getKolichestvoProducta()* menuPlanItem.getKolichestvoPorciy())/1000);
                Rdeficit.save(deficit);
            }
        }
    }
}
