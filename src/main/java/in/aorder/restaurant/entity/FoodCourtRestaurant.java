package in.aorder.restaurant.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "food_court_restaurant")
public class FoodCourtRestaurant extends BaseEntity {

    @Id
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "food_court_id", nullable = false)
    private FoodCourt foodCourt;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

}