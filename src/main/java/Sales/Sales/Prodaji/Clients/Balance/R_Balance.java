package Sales.Sales.Prodaji.Clients.Balance;

import Sales.Sales.Prodaji.Cards.M_Cards;
import Sales.Sales.Prodaji.Clients.M_Clients;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface R_Balance extends JpaRepository<M_Balance,Long> {
    M_Balance getById(Long id);
}
