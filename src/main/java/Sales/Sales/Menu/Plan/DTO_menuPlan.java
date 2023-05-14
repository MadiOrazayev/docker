package Sales.Sales.Menu.Plan;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DTO_menuPlan {
    String nazvanieBlyuda;
    double kolichestvoPorciy;
    double sebestoimostBlyuda;
    double cenaBlyuda;
    LocalDate date;
}
