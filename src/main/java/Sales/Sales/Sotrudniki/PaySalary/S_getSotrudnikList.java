package Sales.Sales.Sotrudniki.PaySalary;

import Sales.Sales.Sotrudniki.DTO_Sotrudnik;
import Sales.Sales.Sotrudniki.M_Sotrudniki;
import Sales.Sales.Sotrudniki.R_Sotrudniki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class S_getSotrudnikList {
    @Autowired
    R_Sotrudniki Rsotrudnik;
    public List<DTO_SotrudnikList> getSotrudnikList() {
        List<DTO_SotrudnikList> DTOsotrudnikList=new ArrayList<>();
        List<M_Sotrudniki> sotrudniki=Rsotrudnik.findAll();
        for(M_Sotrudniki sotrudnik:sotrudniki){
            DTO_SotrudnikList DTOsotrudnik=new DTO_SotrudnikList();
            DTOsotrudnik.setSotrudnikName(sotrudnik.getSotrudnikName());
            DTOsotrudnikList.add(DTOsotrudnik);
        }
        return DTOsotrudnikList;
    }
}
