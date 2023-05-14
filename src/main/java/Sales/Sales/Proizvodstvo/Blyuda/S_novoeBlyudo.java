package Sales.Sales.Proizvodstvo.Blyuda;

import Sales.Sales.Proizvodstvo.Blyuda.Categoryi.M_Categoryi;
import Sales.Sales.Proizvodstvo.Blyuda.Categoryi.R_Categoryi;
import Sales.Sales.Proizvodstvo.Blyuda.Sostav.S_novySostav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_novoeBlyudo {
    @Autowired
    R_Blyuda Rblyuda;
    @Autowired
    S_novySostav SnovySostav;
    @Autowired
    S_obnovitSebestoimost SobnovitSebestoimost;
    @Autowired
    R_Categoryi RcategoriyaBlyuda;
    public String novoeBlyudo(DTOBlyudo DTOblyudo){
        if(DTOblyudo.categoriyaBlyuda==""){
            return "vyberite categoriyu";
        }
        if(DTOblyudo.nazvanieBlyuda==""){
            return "vvedite nazvanie blyuda";
        }
        M_Blyuda blyudo = Rblyuda.getByNazvanieBlyuda(DTOblyudo.nazvanieBlyuda);
        if(blyudo==null) {
            blyudo = new M_Blyuda();
            blyudo.setNazvanieBlyuda(DTOblyudo.nazvanieBlyuda);
            M_Categoryi categoriyaBlyuda=RcategoriyaBlyuda.getByCategoriyaBlyuda(DTOblyudo.categoriyaBlyuda);
            blyudo.setCategoriyaBlyuda(categoriyaBlyuda);
            Rblyuda.save(blyudo);
            SnovySostav.novySostav(DTOblyudo.sostavBlyuda, blyudo);
            SobnovitSebestoimost.obnovitSebestoimost(blyudo);
            return "novoe blyudo saved";
        }else{
            return "blyudo exists";
        }
    }
}
