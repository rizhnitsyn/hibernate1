package by.academy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 18.01.2018.
 */

public class ChatTest {
    private static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

    @Test
    public void testSaveToDb() {
        Session session = SESSION_FACTORY.openSession();
        Chat chat = new Chat("new test");

        session.save(chat);

        Chat foundChat = session.find(Chat.class, 1L);
        Assert.assertEquals("new test", foundChat.getText());
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
