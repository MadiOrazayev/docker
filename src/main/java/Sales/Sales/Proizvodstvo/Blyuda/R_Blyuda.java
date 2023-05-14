package Sales.Sales.Proizvodstvo.Blyuda;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface R_Blyuda extends JpaRepository<M_Blyuda,Long> {
    M_Blyuda getByNazvanieBlyuda(String nazvanieBlyuda);
}
