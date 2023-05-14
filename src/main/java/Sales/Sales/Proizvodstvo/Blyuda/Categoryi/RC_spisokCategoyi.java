package Sales.Sales.Proizvodstvo.Blyuda.Categoryi;

import Sales.Sales.Proizvodstvo.Blyuda.S_spisokBlyud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/categoryi")
public class RC_spisokCategoyi {
    @Autowired
    S_spisokCategoryi SspisokCategoryi;
    @GetMapping(value = "/spisok")
    public List<String> spisokCategoyi() {
        return SspisokCategoryi.spisokCategoryi();
    }
}
