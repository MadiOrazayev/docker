package Sales.Sales.Proizvodstvo.Blyuda.Ceny;

import Sales.Sales.Proizvodstvo.Blyuda.M_Blyuda;
import Sales.Sales.Proizvodstvo.Blyuda.R_Blyuda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class S_posmotretCeny {
    @Autowired
    R_Blyuda Rblyuda;
    public List<DTOCeny> posmotretCeny() {
        List<DTOCeny> ceny=new ArrayList<>();
        List<M_Blyuda> blyuda=Rblyuda.findAll();
        for(M_Blyuda blyudo:blyuda){
            DTOCeny cena=new DTOCeny();
            cena.nazvanieBlyuda=blyudo.getNazvanieBlyuda();
            cena.cenaBlyuda=blyudo.getCenaBlyuda();
            cena.sebestoimostBlyuda=blyudo.getSebestoimostBlyuda();
            ceny.add(cena);
        }
        return ceny;
    }
}
