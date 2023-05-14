package Sales.Sales.Proizvodstvo.Sklad.Deficit;

import Sales.Sales.Proizvodstvo.Sklad.M_Sklad;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface R_Deficit extends JpaRepository<M_Deficit,Long> {
    M_Deficit findByProductAndDate(M_Sklad product, LocalDate date);
    List<M_Deficit> findByProductAndDateLessThanEqual(M_Sklad product, LocalDate date);
    void deleteByDate(LocalDate date);
}
