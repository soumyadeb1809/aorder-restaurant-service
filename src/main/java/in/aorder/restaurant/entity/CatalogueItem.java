package in.aorder.restaurant.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "catalogue_item")
@Where(clause = "deleted = false")
public class CatalogueItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "vegan", nullable = false)
    private Boolean vegan;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "restaurant_id", nullable = false)
    private Integer restaurantId;

    @Column(name = "catalogue_id", nullable = false)
    private Integer catalogueId;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "visible")
    private Boolean visible = true;
    
}
