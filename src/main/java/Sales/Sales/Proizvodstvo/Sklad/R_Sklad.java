package Sales.Sales.Proizvodstvo.Sklad;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface R_Sklad extends JpaRepository<M_Sklad,Long> {
    M_Sklad findByNazvanieProducta(String nazvanieProducta);
}
