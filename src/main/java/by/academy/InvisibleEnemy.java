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
@DiscriminatorValue(value = "invisible")
//@Table(name = "invisible_enemy")
//@PrimaryKeyJoinColumn(name = "employee_id")
public class InvisibleEnemy extends Enemy {

    @Column(name = "invisibility_duration")
    private String invisibilityDuration;
}
