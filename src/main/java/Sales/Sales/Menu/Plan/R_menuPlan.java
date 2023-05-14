package Sales.Sales.Menu.Plan;

import Sales.Sales.Proizvodstvo.Blyuda.M_Blyuda;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface R_menuPlan extends JpaRepository<M_menuPlan,Long> {
    List<M_menuPlan> getByDate(LocalDate date);
    M_menuPlan getByBlyudoAndDate(M_Blyuda item, LocalDate date);
}
