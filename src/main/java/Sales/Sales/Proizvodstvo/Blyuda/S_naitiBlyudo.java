package Sales.Sales.Proizvodstvo.Blyuda;

import Sales.Sales.Proizvodstvo.Blyuda.Sostav.DTOSostav;
import Sales.Sales.Proizvodstvo.Blyuda.Sostav.M_Sostav;
import Sales.Sales.Proizvodstvo.Blyuda.Sostav.R_Sostav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class S_naitiBlyudo {
    @Autowired
    R_Blyuda RBlyuda;
    @Autowired
    R_Sostav RSostav;
    public DTOBlyudo naitiBlyudo(String nazvanieBlyuda){
        M_Blyuda blyudo=RBlyuda.getByNazvanieBlyuda(nazvanieBlyuda);
        if(blyudo==null){
            return null;
        }
        List<M_Sostav> sostav= RSostav.getByBlyudo(blyudo);
        List<DTOSostav> DTOsostav=new ArrayList<>();
        for(M_Sostav s:sostav){
            DTOSostav DTOs=new DTOSostav();
            DTOs.nazvanieProducta=s.getProduct().getNazvanieProducta();
            DTOs.kolichestvoProducta=s.getKolichestvoProducta();
            DTOsostav.add(DTOs);
        }
        DTOBlyudo DTOblyudo=new DTOBlyudo();
        DTOblyudo.setNazvanieBlyuda(nazvanieBlyuda);
        DTOblyudo.setSostavBlyuda(DTOsostav);
        return DTOblyudo;
    }
}

