package by.academy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 27.01.2018.
 */

@Entity
@Table(name = "inventory")
@Getter
@Setter
@NoArgsConstructor
public class Inventory extends BaseEntity {

    @Column(name = "inventory_name", unique = true, nullable = false)
    private String inventoryName;

    @OneToMany(mappedBy = "inventory", fetch = FetchType.LAZY)
    private Set<Items> items = new HashSet<Items>();

    public Inventory(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    @OneToOne(mappedBy = "inventory")
    private Hero hero;

    @Transient
    public void addItem(Items item) {
        items.add(item);
    }
}
