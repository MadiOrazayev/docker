package Sales.Sales.Result;

import Sales.Sales.Proizvodstvo.Sklad.M_Sklad;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
@Transactional
public interface R_Result extends JpaRepository<M_Result,Long> {
    M_Result getByDate(LocalDate date);
    void deleteByDate(LocalDate date);
}
