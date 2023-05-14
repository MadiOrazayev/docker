package Sales.Sales.Proizvodstvo.Blyuda;

import Sales.Sales.Proizvodstvo.Blyuda.Sostav.DTOSostav;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOBlyudo {
    public String nazvanieBlyuda;
    String categoriyaBlyuda;
    public List<DTOSostav> sostavBlyuda;
}
