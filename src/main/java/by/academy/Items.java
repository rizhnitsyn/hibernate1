package by.academy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by user on 27.01.2018.
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Items extends BaseEntity {

    @Column(name = "item_name")
    private String itemName;

    @ManyToOne
    @JoinColumn(name =  "inventory_id")
    private Inventory inventory;

    public Items(String itemName) {
        this.itemName = itemName;
    }
}
