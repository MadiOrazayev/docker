package Sales.Sales.Menu.Plan;

import Sales.Sales.Proizvodstvo.Blyuda.M_Blyuda;
import Sales.Sales.Proizvodstvo.Blyuda.R_Blyuda;
import Sales.Sales.Proizvodstvo.Sklad.Deficit.S_calcDeficit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class S_saveMenuPlan {
    @Autowired
    R_menuPlan RmenuPlan;
    @Autowired
    R_Blyuda Rblyuda;
    @Autowired
    S_calcDeficit ScalcDeficit;
    public String saveMenuPlan(List<DTO_menuPlan> DTOmenuPlan){
        LocalDate date=LocalDate.now();
        for(DTO_menuPlan DTOmenuItem:DTOmenuPlan){
            M_Blyuda blyudo=Rblyuda.getByNazvanieBlyuda(DTOmenuItem.nazvanieBlyuda);
            M_menuPlan menuPlanItem = RmenuPlan.getByBlyudoAndDate(blyudo,DTOmenuItem.date);
            if(DTOmenuItem.kolichestvoPorciy==0){
                RmenuPlan.delete(menuPlanItem);
            }else{
                menuPlanItem.setKolichestvoPorciy(DTOmenuItem.kolichestvoPorciy);
                RmenuPlan.save(menuPlanItem);
                date=DTOmenuItem.date;
            }
        }
        ScalcDeficit.calcDeficit(date);
        return "menu plan saved";
    }
}
