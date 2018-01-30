package by.academy;

import by.academy.BaseEntity;
import lombok.*;

import javax.persistence.*;

/**
 * Created by user on 30.01.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name = "enemy")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = )
public abstract class Enemy extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;
}
