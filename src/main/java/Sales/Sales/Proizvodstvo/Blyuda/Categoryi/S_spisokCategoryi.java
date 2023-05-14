package Sales.Sales.Proizvodstvo.Blyuda.Categoryi;

import Sales.Sales.Proizvodstvo.Blyuda.M_Blyuda;
import Sales.Sales.Proizvodstvo.Blyuda.R_Blyuda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class S_spisokCategoryi {
    @Autowired
    R_Categoryi RcategoryiBlyuda;
    public List<String> spisokCategoryi(){
        List<M_Categoryi> categoryi=RcategoryiBlyuda.findAll();
        List<String> spisokCategoryi=new ArrayList<>();
        for(M_Categoryi categorya:categoryi){
            spisokCategoryi.add(categorya.categoriyaBlyuda);
        }
        return spisokCategoryi;
    }
}
