package Sales.Sales.Prodaji.Clients.Balance;

import Sales.Sales.Prodaji.Clients.M_Clients;
import Sales.Sales.Prodaji.Clients.R_Clients;
import Sales.Sales.Prodaji.Sales.M_Sales;
import Sales.Sales.Prodaji.Sales.M_Sales_History;
import Sales.Sales.Prodaji.Sales.RC_Sales_History;
import Sales.Sales.Prodaji.Sales.R_Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class S_getBalance {
    @Autowired
    R_Balance Rbalance;
    @Autowired
    R_Sales Rsales;
    @Autowired
    R_Clients Rclients;
    public int getBalance(String clientName){
        M_Clients client=Rclients.findByClientName(clientName);
        List<M_Sales> sales=Rsales.findByClientAndDate(client, LocalDate.now());
        int bal=0;
        for(M_Sales sale:sales){
            bal+=sale.getRevenueCard();
        }
        M_Balance Mbalance=Rbalance.getById(1l);
        client.setBalance(Mbalance.getBalance()-bal);
        Rclients.save(client);
        return client.getBalance();
    }
}
