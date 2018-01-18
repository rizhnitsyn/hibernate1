package by.academy;

import by.academy.Chat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by user on 18.01.2018.
 */
public class MappingChat {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Chat chat = new Chat("my chat");
        session.save(chat);

        Chat chat1 = session.find(Chat.class, 1L);
        System.out.println(chat1);

        session.close();
        sessionFactory.close();
    }
}
