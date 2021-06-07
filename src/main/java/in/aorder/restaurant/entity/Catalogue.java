package in.aorder.restaurant.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "catalogue")
public class Catalogue extends BaseEntity {

    @Id
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id", nullable = false)
    private CatalogueItem item;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private CatalogueCategory category;

    @Column(name = "visible", nullable = false)
    private Boolean visible;

}
