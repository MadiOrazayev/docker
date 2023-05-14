package Sales.Sales.Prodaji.Sales;

import Sales.Sales.Prodaji.Clients.M_Clients;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface R_Sales extends JpaRepository<M_Sales,Long> {
    List<M_Sales> findByClientAndDate(M_Clients client, LocalDate date);
    List<M_Sales> findByDate(LocalDate date);
}
