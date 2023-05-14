package Sales.Sales.Proizvodstvo.Blyuda.Ceny;

import Sales.Sales.Menu.Fact.M_menuFact;
import Sales.Sales.Menu.Fact.R_menuFact;
import Sales.Sales.Proizvodstvo.Blyuda.M_Blyuda;
import Sales.Sales.Proizvodstvo.Blyuda.R_Blyuda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class S_sohranitCeny {
    @Autowired
    R_Blyuda Rblyuda;
    @Autowired
    R_menuFact RmenuFact;
    public String sohranitCeny(List<DTOCeny> DTOceny) {
        for(DTOCeny DTOcena:DTOceny){
            M_Blyuda blyudo = Rblyuda.getByNazvanieBlyuda(DTOcena.nazvanieBlyuda);
            blyudo.setCenaBlyuda(DTOcena.cenaBlyuda);
            Rblyuda.save(blyudo);
            for(M_menuFact menufact: RmenuFact.getByItemNameAndDateIsGreaterThanEqual(blyudo.getNazvanieBlyuda(), LocalDate.now())){
                menufact.setItemPrice(DTOcena.cenaBlyuda);
                RmenuFact.save(menufact);
            }
        }
        return "saved";
    }
}
