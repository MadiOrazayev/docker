package Sales.Sales.Menu.Fact;

import Sales.Sales.Proizvodstvo.Blyuda.Sostav.R_Sostav;
import Sales.Sales.Menu.Plan.M_menuPlan;
import Sales.Sales.Menu.Plan.R_menuPlan;
import Sales.Sales.Proizvodstvo.Sklad.Deficit.M_Deficit;
import Sales.Sales.Proizvodstvo.Sklad.Deficit.R_Deficit;
import Sales.Sales.Proizvodstvo.Sklad.M_Sklad;
import Sales.Sales.Proizvodstvo.Sklad.R_Sklad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class S_saveMenuFact {
    @Autowired
    R_menuFact RmenuFact;
    @Autowired
    R_menuPlan RmenuPlan;
    public String saveMenuFact(LocalDate date) {
        if(date.isBefore(LocalDate.now())){
            return "data uje proshla";
        }
        if(checkSklad(date)) {
            for (M_menuPlan menuPlanItem : RmenuPlan.getByDate(date)) {
                M_menuFact menuFactItem = RmenuFact.getByItemNameAndDate(menuPlanItem.getBlyudo().getNazvanieBlyuda(), date);
                if (menuFactItem != null) {
                    menuFactItem.setItemCost((menuFactItem.getItemAmount() * menuFactItem.getItemCost()
                            + menuPlanItem.getKolichestvoPorciy() * menuPlanItem.getBlyudo().getSebestoimostBlyuda())
                            / (menuFactItem.getItemAmount() + menuPlanItem.getKolichestvoPorciy()));
                    menuFactItem.setItemAmount(menuFactItem.getItemAmount() + menuPlanItem.getKolichestvoPorciy());
                    menuFactItem.setItemLeft(menuFactItem.getItemAmount() - menuFactItem.getItemSold());
                } else {
                    menuFactItem = new M_menuFact();
                    menuFactItem.setItemName(menuPlanItem.getBlyudo().getNazvanieBlyuda());
                    menuFactItem.setItemCategory(menuPlanItem.getBlyudo().getCategoriyaBlyuda().getCategoriyaBlyuda());
                    menuFactItem.setItemAmount(menuPlanItem.getKolichestvoPorciy());
                    menuFactItem.setItemSold(0);
                    menuFactItem.setItemLeft(menuPlanItem.getKolichestvoPorciy());
                    menuFactItem.setItemCost(menuPlanItem.getBlyudo().getSebestoimostBlyuda());
                    menuFactItem.setItemPrice(menuPlanItem.getBlyudo().getCenaBlyuda());
                    menuFactItem.setDate(date);
                }
                RmenuFact.save(menuFactItem);
                RmenuPlan.delete(menuPlanItem);
                takeFromSklad(date);
            }
            return "menu saved";
        }else{
            return "products insufficient";
        }
    }

    @Autowired
    R_Sostav calculRepository;
    @Autowired
    R_Sklad Rsklad;
    @Autowired
    R_Deficit Rdeficit;

    public void takeFromSklad(LocalDate date) {
        for(M_Sklad product:Rsklad.findAll()){
            M_Deficit deficit=Rdeficit.findByProductAndDate(product,date);
            if(deficit!=null) {
                product.setOstatokNaSklade(product.getOstatokNaSklade() - deficit.getDeficit());
                Rdeficit.delete(deficit);
                Rsklad.save(product);
            }
        }
    }
    public boolean checkSklad(LocalDate date) {
        boolean sufficient = true;
        for(M_Sklad product:Rsklad.findAll()){
            M_Deficit deficit=Rdeficit.findByProductAndDate(product,date);
            if(deficit!=null){
                if(product.getOstatokNaSklade()<deficit.getDeficit()){
                    sufficient=false;
                }
            }
        }
        return sufficient;
    }
}
