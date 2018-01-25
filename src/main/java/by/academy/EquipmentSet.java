package by.academy;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by user on 25.01.2018.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class EquipmentSet {

    @Column(name = "melee_weapon")
    private String meleeWeapon;

    @Column(name = "range_weapon")
    private String rangeWeapon;


}
