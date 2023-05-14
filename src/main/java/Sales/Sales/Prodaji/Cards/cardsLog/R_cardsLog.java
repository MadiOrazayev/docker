package Sales.Sales.Prodaji.Cards.cardsLog;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface R_cardsLog extends JpaRepository<M_cardsLog,Long> {
}
