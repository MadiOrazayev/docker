package Sales.Sales;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Base_Entity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
}
