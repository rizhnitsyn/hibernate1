package by.academy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

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

    @Column(name = "text", unique = true, nullable = false)
    private String text;

//    @Temporal(value = TemporalType.DATE)
//    private Date date;

//    @Column(name = "test")
//    private LocalDate localDate;

    public Chat(String text) {
        this.text = text;
    }

}
