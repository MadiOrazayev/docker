package Sales.Sales.Sotrudniki;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface R_Roles extends JpaRepository<M_Roles,Long> {
    M_Roles getByRole(String sotrudnikRole);
}
