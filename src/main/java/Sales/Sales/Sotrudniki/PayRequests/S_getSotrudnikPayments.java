package Sales.Sales.Sotrudniki.PayRequests;

import Sales.Sales.Sotrudniki.DTO_Sotrudnik;
import Sales.Sales.Sotrudniki.M_Sotrudniki;
import Sales.Sales.Sotrudniki.R_Sotrudniki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_getSotrudnikPayments {
    @Autowired
    R_Sotrudniki Rsotrudnik;
    public DTO_Sotrudnik getSotrudnikPayments(String sotrudnikName) {

        M_Sotrudniki sotrudnik=Rsotrudnik.getBySotrudnikName(sotrudnikName);
        DTO_Sotrudnik DTOsotrudnik=new DTO_Sotrudnik();
        DTOsotrudnik.setSotrudnikContact(sotrudnik.getSotrudnikContact());
        DTOsotrudnik.setKaspi(sotrudnik.getKaspi());
        DTOsotrudnik.setSotrudnikPosition(sotrudnik.getSotrudnikPosition());
        DTOsotrudnik.setSotrudnikPayedBasic(sotrudnik.getSotrudnikPayedBasic());
        DTOsotrudnik.setSotrudnikPayedExtra(sotrudnik.getSotrudnikPayedExtra());
        DTOsotrudnik.setSotrudnikToBePayedBasic(sotrudnik.getSotrudnikToBePayedBasic());
        DTOsotrudnik.setSotrudnikToBePayedExtra(sotrudnik.getSotrudnikToBePayedExtra());
        return DTOsotrudnik;
    }
}
