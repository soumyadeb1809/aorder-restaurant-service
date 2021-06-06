package in.aorder.restaurant.model;

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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "food_court_id", nullable = false)
    private FoodCourt foodCourt;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

}
