package Sales.Sales.Proizvodstvo.Sklad.Zakup;

import Sales.Sales.Proizvodstvo.Blyuda.M_Blyuda;
import Sales.Sales.Proizvodstvo.Blyuda.R_Blyuda;
import Sales.Sales.Proizvodstvo.Blyuda.S_obnovitSebestoimost;
import Sales.Sales.Proizvodstvo.Sklad.M_Sklad;
import Sales.Sales.Proizvodstvo.Sklad.R_Sklad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_Zakup {
    @Autowired
    R_Sklad Rsklad;
    @Autowired
    R_Blyuda Rblyuda;
    @Autowired
    S_obnovitSebestoimost SobnovitSebestoimost;
    public String addZakup(List<DTO_Zakup> DTOzakup) {
        for (DTO_Zakup zakup : DTOzakup) {
            M_Sklad sklad = Rsklad.findByNazvanieProducta(zakup.nazvanieProducta);
            sklad.setSrednyayaCena((sklad.getSrednyayaCena() * sklad.getOstatokNaSklade()
                    + zakup.cenaProducta * zakup.kolichestvoProducta)
                    / (sklad.getOstatokNaSklade() + zakup.kolichestvoProducta));
            sklad.setOstatokNaSklade(sklad.getOstatokNaSklade() + zakup.kolichestvoProducta);
            Rsklad.save(sklad);
        }
        for(M_Blyuda blyudo:Rblyuda.findAll()){
            SobnovitSebestoimost.obnovitSebestoimost(blyudo);
        }
        return "zakup added";
    }
}
