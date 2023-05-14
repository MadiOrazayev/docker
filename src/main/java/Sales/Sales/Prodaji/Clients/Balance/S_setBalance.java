package Sales.Sales.Prodaji.Clients.Balance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class S_setBalance {
    @Autowired
    R_Balance Rbalance;
    public String setBalance(int balance){
        M_Balance Mbalance;
        if(!Rbalance.existsById(1l)){
            Mbalance=new M_Balance();
        }else{
            Mbalance=Rbalance.getById(1l);
        }
        Mbalance.setBalance(balance);
        Rbalance.save(Mbalance);
        return "balance set";
    }
}
