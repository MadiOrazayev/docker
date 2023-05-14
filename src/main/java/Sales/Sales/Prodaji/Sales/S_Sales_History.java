package Sales.Sales.Prodaji.Sales;

import Sales.Sales.Menu.Fact.M_menuFact;
import Sales.Sales.Menu.Fact.R_menuFact;
import Sales.Sales.Prodaji.Clients.M_Clients;
import Sales.Sales.Prodaji.Clients.R_Clients;
import Sales.Sales.Proizvodstvo.Blyuda.M_Blyuda;
import Sales.Sales.Proizvodstvo.Blyuda.R_Blyuda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;


@Service
public class S_Sales_History {
    @Autowired
    R_Blyuda blyuda;
    @Autowired
    R_Clients clients;
    @Autowired
    R_Sales Rsales;
    @Autowired
    R_Sales_History RsalesH;

    @Autowired
    R_menuFact RmenuFact;

    public String save(DTO_Sales_History sales){
        M_Clients client=clients.findByClientName(sales.clientName);
        double cost=0;
        for(DTO_Sales_History_Blyuda DTOblyudo:sales.getBlyuda()) {
            M_Blyuda blyudo = blyuda.getByNazvanieBlyuda(DTOblyudo.blyudoName);
            M_Sales_History Msales=new M_Sales_History();
            Msales.setClient(client);
            Msales.setBlyudo(blyudo);
            Msales.setSebes(blyudo.getSebestoimostBlyuda() * DTOblyudo.porciyi);
            Msales.setPorciyi(DTOblyudo.porciyi);
            Msales.setPrice(DTOblyudo.price);
            Msales.setProfit(DTOblyudo.price * DTOblyudo.porciyi - blyudo.getSebestoimostBlyuda() * DTOblyudo.porciyi);
            Msales.setDate(LocalDate.now());
            Msales.setTime(LocalTime.now());
            cost+=Msales.getSebes();
            RsalesH.save(Msales);

            M_menuFact Mmenufact= RmenuFact.getByItemNameAndDate(blyudo.getNazvanieBlyuda(),LocalDate.now());
            Mmenufact.setItemSold(Mmenufact.getItemSold()+DTOblyudo.porciyi);
            Mmenufact.setItemLeft(Mmenufact.getItemLeft()-DTOblyudo.porciyi);
            RmenuFact.save(Mmenufact);
        }
        M_Sales Msale=new M_Sales();
        Msale.setClient(client);
        Msale.setRevenueCard(sales.rev_card);
        Msale.setRevenueKaspiCash(sales.rev_kaspi_cash);
        Msale.setTax(sales.rev_card*0.08+sales.rev_kaspi_cash*0.04);
        Msale.setCost(cost);
        Msale.setProfit(Msale.getRevenueCard()+Msale.getRevenueKaspiCash()-Msale.getCost()-Msale.getTax());
        Msale.setDate(LocalDate.now());
        Rsales.save(Msale);
        return "saved";
    }
}
