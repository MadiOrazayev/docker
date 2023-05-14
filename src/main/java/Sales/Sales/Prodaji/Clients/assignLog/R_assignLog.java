package Sales.Sales.Prodaji.Clients.assignLog;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface R_assignLog extends JpaRepository<M_assignLog,Long> {
}
