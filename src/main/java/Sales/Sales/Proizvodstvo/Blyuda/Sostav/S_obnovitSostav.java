package Sales.Sales.Proizvodstvo.Blyuda.Sostav;

import Sales.Sales.Proizvodstvo.Blyuda.M_Blyuda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_obnovitSostav {

    @Autowired
    R_Sostav Rsostav;
    @Autowired
    S_novySostav SnovySostav;
    public void obnovitSostav(List<DTOSostav> DTOsostavBlyuda, M_Blyuda blyudo){
        Rsostav.deleteAllByBlyudo(blyudo);
        SnovySostav.novySostav(DTOsostavBlyuda,blyudo);
    }
}
