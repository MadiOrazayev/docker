package Sales.Sales.Proizvodstvo.Blyuda;

import Sales.Sales.Proizvodstvo.Blyuda.Sostav.R_Sostav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class S_spisokBlyud {
    @Autowired
    R_Blyuda RBlyuda;
    public List<String> spisokBlyud(){
        List<M_Blyuda> blyuda=RBlyuda.findAll();
        List<String> spisokBlyud=new ArrayList<>();
        for(M_Blyuda blyudo:blyuda){
            spisokBlyud.add(blyudo.nazvanieBlyuda);
        }
        return spisokBlyud;
    }
}
