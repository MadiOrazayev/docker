package Sales.Sales.Result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTO_Result {
    LocalDate date;
    double dohodCard;
    double dohodKaspiNal;
    double tax;
    double producty;
    double ostatki;
    double zarplata;
    double arenda;
    double kommunalnye;
    double profit;
}
