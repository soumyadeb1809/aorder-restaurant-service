package in.aorder.restaurant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "restaurant")
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
