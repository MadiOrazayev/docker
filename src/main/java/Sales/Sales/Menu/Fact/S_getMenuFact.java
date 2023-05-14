package Sales.Sales.Menu.Fact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class S_getMenuFact {
    @Autowired
    R_menuFact menuFactRepository;
    public List<DTO_menuFact> getMenuFact(LocalDate date){
        List<DTO_menuFact> menuFact=new ArrayList<>();
        if(menuFactRepository.getByDate(date)!=null){
        for(M_menuFact menuItem:menuFactRepository.getByDate(date)){
            DTO_menuFact menuFactItem=new DTO_menuFact();
            menuFactItem.setItemName(menuItem.getItemName());
            menuFactItem.setItemCategory(menuItem.getItemCategory());
            menuFactItem.setItemAmount(menuItem.getItemAmount());
            menuFactItem.setItemSold(menuItem.getItemSold());
            menuFactItem.setItemLeft(menuItem.getItemLeft());
            menuFactItem.setItemCost(menuItem.getItemCost());
            menuFactItem.setItemPrice(menuItem.getItemPrice());
            menuFactItem.setDate(date);
            menuFact.add(menuFactItem);
        }
        }
        return menuFact;
    }
}
