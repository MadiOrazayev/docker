package Sales.Sales.Prodaji.Clients;

import Sales.Sales.Prodaji.Cards.M_Cards;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface R_Clients extends JpaRepository<M_Clients,Long> {
    M_Clients findByClientName(String clientName);
    M_Clients findByCard(M_Cards card);
}
