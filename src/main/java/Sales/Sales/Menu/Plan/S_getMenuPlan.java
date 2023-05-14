package Sales.Sales.Menu.Plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class S_getMenuPlan {
    @Autowired
    R_menuPlan RmenuPlan;
    public List<DTO_menuPlan> getMenuPlan(LocalDate date) {
        List<DTO_menuPlan> menuPlan = new ArrayList<>();
        if (RmenuPlan.getByDate(date) != null) {
            for (M_menuPlan menuItem : RmenuPlan.getByDate(date)) {
                DTO_menuPlan menuPlanItem = new DTO_menuPlan();
                menuPlanItem.setNazvanieBlyuda(menuItem.getBlyudo().getNazvanieBlyuda());
                menuPlanItem.setKolichestvoPorciy(menuItem.getKolichestvoPorciy());
                menuPlanItem.setSebestoimostBlyuda(menuItem.getBlyudo().getSebestoimostBlyuda());
                menuPlanItem.setCenaBlyuda(menuItem.getBlyudo().getCenaBlyuda());
                menuPlan.add(menuPlanItem);
            }
            return menuPlan;
        }
        return null;
    }
}
