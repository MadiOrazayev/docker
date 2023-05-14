package Sales.Sales.Proizvodstvo.Sklad;

import Sales.Sales.Proizvodstvo.Sklad.Deficit.M_Deficit;
import Sales.Sales.Proizvodstvo.Sklad.Deficit.R_Deficit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class S_posmotretSklad {
    @Autowired
    R_Sklad Rsklad;
    @Autowired
    R_Deficit Rdeficit;
    public List<DTO_Sklad> getProducts(LocalDate date){
        List<DTO_Sklad> products=new ArrayList<>();
        for(M_Sklad sklad:Rsklad.findAll()){
            DTO_Sklad product=new DTO_Sklad();
            product.setProductName(sklad.getNazvanieProducta());
            product.setProductLeft(sklad.getOstatokNaSklade());
            product.setProductAvPrice(sklad.getSrednyayaCena());
            List<M_Deficit> deficit=Rdeficit.findByProductAndDateLessThanEqual(sklad,date);
            if(deficit!=null) {
                for(M_Deficit deficitItem:deficit) {
                    product.setProductDeficit(product.getProductDeficit()+deficitItem.getDeficit());
                }
            }
            products.add(product);
        }
        return products;
    }
}
