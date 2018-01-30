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
@DiscriminatorValue(value = "armored")
//@Table(name = "armored_enemy")
//@PrimaryKeyJoinColumn(name = "employee_id")
public class ArmoredEnemy extends Enemy {

    @Column(name = "armor_type")
    private String armorType;

    @Column(name = "armor_durability")
    private String armorDurability;
}
