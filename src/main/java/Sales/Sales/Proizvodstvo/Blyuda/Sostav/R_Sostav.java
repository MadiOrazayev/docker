package Sales.Sales.Proizvodstvo.Blyuda.Sostav;

import Sales.Sales.Proizvodstvo.Blyuda.M_Blyuda;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface R_Sostav extends JpaRepository<M_Sostav,Long> {
    void deleteAllByBlyudo(M_Blyuda blyudo);
    List<M_Sostav> getByBlyudo(M_Blyuda blyudo);
}
