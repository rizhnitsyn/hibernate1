package by.academy;

import lombok.*;

import javax.persistence.*;

/**
 * Created by user on 30.01.2018.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@DiscriminatorValue(value = "ranged")
//@Table(name = "range_enemy")
//@PrimaryKeyJoinColumn(name = "employee_id")
public class RangedEnemy extends Enemy {

    @Column(name = "weapon_type")
    private String weaponType;

    @Column(name = "range_of_fire")
    private String rangeOfFire;
}
