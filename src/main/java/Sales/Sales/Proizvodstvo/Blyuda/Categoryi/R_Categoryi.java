package Sales.Sales.Proizvodstvo.Blyuda.Categoryi;

import Sales.Sales.Proizvodstvo.Blyuda.M_Blyuda;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface R_Categoryi extends JpaRepository<M_Categoryi,Long> {
    M_Categoryi getByCategoriyaBlyuda(String categoriyaBlyuda);
}
