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
@Table(name = "food_court")
@Where(clause = "deleted = false")
public class FoodCourt extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "logo_path")
    private String logoPath;

    @Column(name = "theme_id")
    private Integer themeId;

    @Column(name = "location_id", nullable = false)
    private Integer locationId;

    @Column(name = "qr_id")
    private Integer qrId;

}
