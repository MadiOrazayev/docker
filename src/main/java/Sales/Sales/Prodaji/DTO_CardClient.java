package Sales.Sales.Prodaji;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTO_CardClient {
    int cardNumber;
    String cardStatus;
    String clientName;
    String clientStatus;
    double balance;
    public DTO_CardClient(){
        this.cardNumber=0;
        this.cardStatus="";
        this.clientName="";
        this.clientStatus="";
        this.balance=0;
    }
}
