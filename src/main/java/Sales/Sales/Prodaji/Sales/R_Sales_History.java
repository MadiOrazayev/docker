package Sales.Sales.Prodaji.Sales;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface R_Sales_History extends JpaRepository<M_Sales_History,Long> {
}
