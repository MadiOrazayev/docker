package Sales.Sales.Proizvodstvo.Blyuda;

import Sales.Sales.Proizvodstvo.Blyuda.Sostav.S_novySostav;
import Sales.Sales.Proizvodstvo.Blyuda.Sostav.S_obnovitSostav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class S_sohranitBlyudo {
    @Autowired
    R_Blyuda Rblyuda;
    @Autowired
    S_novoeBlyudo SnovoeBlyudo;
    @Autowired
    S_novySostav SnovySostav;
    @Autowired
    S_obnovitSostav SobnovitSostav;
    @Autowired
    S_obnovitSebestoimost SobnovitSebestoimost;
    public String sohranitBlyudo(DTOBlyudo DTOblyudo) {
        M_Blyuda blyudo = Rblyuda.getByNazvanieBlyuda(DTOblyudo.nazvanieBlyuda);
        if(blyudo==null){
            return "blyudo doesn't exist";
        }else{
            SobnovitSostav.obnovitSostav(DTOblyudo.sostavBlyuda,blyudo);
            SobnovitSebestoimost.obnovitSebestoimost(blyudo);
        }
        return "saved";
    }
}
