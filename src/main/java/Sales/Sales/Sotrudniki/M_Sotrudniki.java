package Sales.Sales.Sotrudniki;

import Sales.Sales.Base_Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name="sotrudniki")
@Getter
@Setter
public class M_Sotrudniki extends Base_Entity implements UserDetails {
    private String sotrudnikName;
    private String sotrudnikPassword;
    private String sotrudnikContact;
    private String Kaspi;
    private String sotrudnikPosition;
    private double sotrudnikPayedBasic;
    private double sotrudnikPayedExtra;
    private double sotrudnikToBePayedBasic;
    private double sotrudnikToBePayedExtra;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<M_Roles> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return sotrudnikPassword;
    }

    @Override
    public String getUsername() {
        return sotrudnikName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
