package by.academy;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by user on 30.01.2018.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "armored_enemy")
@PrimaryKeyJoinColumn(name = "employee_id")
public class ArmoredEnemy extends Enemy {

    @Column(name = "armor_type")
    private String armorType;

    @Column(name = "armor_durability")
    private String armorDurability;
}
