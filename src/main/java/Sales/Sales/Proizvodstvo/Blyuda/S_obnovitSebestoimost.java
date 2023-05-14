package Sales.Sales.Proizvodstvo.Blyuda;

import Sales.Sales.Proizvodstvo.Blyuda.Sostav.DTOSostav;
import Sales.Sales.Proizvodstvo.Blyuda.Sostav.M_Sostav;
import Sales.Sales.Proizvodstvo.Blyuda.Sostav.R_Sostav;
import Sales.Sales.Proizvodstvo.Sklad.M_Sklad;
import Sales.Sales.Proizvodstvo.Sklad.R_Sklad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_obnovitSebestoimost {
    @Autowired
    R_Sklad Rsklad;
    @Autowired
    R_Sostav Rsostav;
    @Autowired
    R_Blyuda Rblyuda;
    public void obnovitSebestoimost(M_Blyuda blyudo){
        double sebestoimost=0;
        List<M_Sostav> sostav=Rsostav.getByBlyudo(blyudo);
        for (M_Sostav sostavItem : sostav) {
            M_Sklad product=sostavItem.getProduct();
            sebestoimost+=(product.getSrednyayaCena()*sostavItem.getKolichestvoProducta())/1000;
        }
        blyudo.setSebestoimostBlyuda(sebestoimost);
        Rblyuda.save(blyudo);
    }
}
