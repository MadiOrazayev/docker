package Sales.Sales.Proizvodstvo.Blyuda.Sostav;

import Sales.Sales.Proizvodstvo.Blyuda.M_Blyuda;
import Sales.Sales.Proizvodstvo.Blyuda.S_obnovitSebestoimost;
import Sales.Sales.Proizvodstvo.Sklad.M_Sklad;
import Sales.Sales.Proizvodstvo.Sklad.R_Sklad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_novySostav {
    @Autowired
    R_Sklad Rsklad;
    @Autowired
    R_Sostav Rsostav;
    public void novySostav(List<DTOSostav> DTOsostavBlyuda, M_Blyuda blyudo){
        for (DTOSostav DTOsostav : DTOsostavBlyuda) {
            if(DTOsostav.kolichestvoProducta!=0) {
                M_Sostav sostav = new M_Sostav();
                sostav.setBlyudo(blyudo);
                M_Sklad product = Rsklad.findByNazvanieProducta(DTOsostav.nazvanieProducta);
                sostav.setProduct(product);
                sostav.setKolichestvoProducta(DTOsostav.kolichestvoProducta);
                Rsostav.save(sostav);
            }
        }
    }
}
