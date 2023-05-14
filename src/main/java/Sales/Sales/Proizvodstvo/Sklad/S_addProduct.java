package Sales.Sales.Proizvodstvo.Sklad;

import Sales.Sales.Proizvodstvo.Sklad.Zakup.DTO_Zakup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_addProduct {
    @Autowired
    R_Sklad Rsklad;
    public String addProduct(String nazvanieProducta){
        M_Sklad sklad=Rsklad.findByNazvanieProducta(nazvanieProducta);
        if(sklad==null){
            sklad=new M_Sklad();
            sklad.setNazvanieProducta(nazvanieProducta);
            sklad.setOstatokNaSklade(0);
            sklad.setSrednyayaCena(0);
            Rsklad.save(sklad);
            return "dobavleno";
        }else{
            return "product exists";
        }
    }
}
