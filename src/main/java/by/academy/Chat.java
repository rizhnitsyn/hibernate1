package by.academy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by user on 18.01.2018.
 */

@Entity
@Table(name = "chat")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    public Chat(String text) {
        this.text = text;
    }

}
