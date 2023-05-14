package Sales.Sales.Sotrudniki.PayRequests;

import Sales.Sales.Sotrudniki.M_Sotrudniki;
import Sales.Sales.Sotrudniki.PayRequests.M_PaymentScheme;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface R_PaymentScheme extends JpaRepository<M_PaymentScheme,Long> {
    List<M_PaymentScheme> findBySotrudnik(M_Sotrudniki sotrudnik);
    List<M_PaymentScheme> findByDate(LocalDate date);
}
