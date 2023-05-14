package Sales.Sales.Prodaji.Cards;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface R_Cards extends JpaRepository<M_Cards,Long> {
    M_Cards findByCardNumber(int cardNumber);
}
