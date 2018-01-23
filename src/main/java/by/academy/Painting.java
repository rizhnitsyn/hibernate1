package by.academy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "painting")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Painting {

    public Painting(String name, String authorName, Rarity rarity) {
        this.name = name;
        this.authorName = authorName;
        this.rarity = rarity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "authorName")
    private String authorName;

    @Enumerated(EnumType.STRING)
    @Column(name = "rarity")
    private Rarity rarity;
}
