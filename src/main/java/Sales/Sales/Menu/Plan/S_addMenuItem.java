package Sales.Sales.Menu.Plan;

import Sales.Sales.Proizvodstvo.Blyuda.M_Blyuda;
import Sales.Sales.Proizvodstvo.Blyuda.R_Blyuda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class S_addMenuItem {
    @Autowired
    R_menuPlan RmenuPlan;
    @Autowired
    R_Blyuda Rblyuda;
    public String addMenuItem(DTO_menuPlan menuitem){
        M_Blyuda blyudo=Rblyuda.getByNazvanieBlyuda(menuitem.nazvanieBlyuda);
            if (RmenuPlan.getByBlyudoAndDate(blyudo,menuitem.getDate()) == null) {
                M_menuPlan menuPlanItem = new M_menuPlan();
                menuPlanItem.setBlyudo(blyudo);
                menuPlanItem.setDate(menuitem.getDate());
                RmenuPlan.save(menuPlanItem);
                return "item added";
            }
            else {
                return "menu has item already";
            }
    }
}
