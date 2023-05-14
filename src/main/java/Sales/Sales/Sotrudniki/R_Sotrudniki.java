package Sales.Sales.Sotrudniki;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface R_Sotrudniki extends JpaRepository<M_Sotrudniki,Long> {
    M_Sotrudniki getBySotrudnikName(String sotrudnikName);
}
