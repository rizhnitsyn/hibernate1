package by.academy;

import lombok.*;

import javax.persistence.*;

/**
 * Created by user on 25.01.2018.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "hero")
@Entity
public class Hero extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    public Hero(String name, Gender gender, EquipmentSet firstEquipmentSet, EquipmentSet secondEquipmentSet) {
        this.name = name;
        this.gender = gender;
        this.firstEquipmentSet = firstEquipmentSet;
        this.secondEquipmentSet = secondEquipmentSet;
    }

    public Hero(String name, Gender gender) {

        this.name = name;
        this.gender = gender;
    }

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "meleeWeapon", column = @Column(name = "first_melee_weapon")),
            @AttributeOverride(name = "rangeWeapon", column = @Column(name = "first_range_weapon"))
    })
    private EquipmentSet firstEquipmentSet;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "meleeWeapon", column = @Column(name = "second_melee_weapon")),
            @AttributeOverride(name = "rangeWeapon", column = @Column(name = "second_range_weapon"))
    })
    private EquipmentSet secondEquipmentSet;

    @OneToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @Transient
    public boolean isMan() {
        return gender == Gender.MALE;
    }

    @Transient
    public boolean isWoman() {
        return gender == Gender.FEMALE;
    }


}
