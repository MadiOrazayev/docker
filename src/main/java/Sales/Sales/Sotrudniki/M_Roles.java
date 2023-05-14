package Sales.Sales.Sotrudniki;

import Sales.Sales.Base_Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="sotrudnikroles")
@Getter
@Setter
public class M_Roles extends Base_Entity implements GrantedAuthority {
    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}
