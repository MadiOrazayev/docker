package Sales.Sales.Sotrudniki;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Sotrudnik {
    public String sotrudnikPosition;
    public String sotrudnikContact;
    public String Kaspi;
    public double sotrudnikPayedBasic;
    public double sotrudnikPayedExtra;
    public double sotrudnikToBePayedBasic;
    public double sotrudnikToBePayedExtra;
}
