package Sales.Sales.Menu.Fact;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface R_menuFact extends JpaRepository<M_menuFact,Long> {
    List<M_menuFact> getByDate(LocalDate date);
    M_menuFact getByItemNameAndDate(String itemName, LocalDate date);
    List<M_menuFact> getByItemNameAndDateIsGreaterThanEqual(String itemName, LocalDate date);
}
