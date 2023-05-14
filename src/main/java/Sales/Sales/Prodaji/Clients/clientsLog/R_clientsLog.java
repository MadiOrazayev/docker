package Sales.Sales.Prodaji.Clients.clientsLog;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface R_clientsLog extends JpaRepository<M_clientsLog,Long> {
}
