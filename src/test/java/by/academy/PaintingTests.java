package by.academy;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by user on 23.01.2018.
 */
public class PaintingTests {
    private static final SessionFactory SESSION_FACTORY = new Configuration().configure("hibernate_mysql.cfg.xml").buildSessionFactory();
//    private static final Logger LOGGER = new Logger(PaintingTests.class);

    @Test
    public void testSave() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Painting painting = new Painting("Утро в сосновом лесу", "Шишкин", Rarity.STRONG);
        session.save(painting);

        transaction.commit();
        session.close();
        SESSION_FACTORY.close();
    }

   @Test
    public void testSaveOrUpdate() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Painting painting = new Painting("Утро в сосновом лесу", "Шишкин", Rarity.STRONG);
        session.save(painting);

        session.evict(painting);
        painting.setAuthorName("Шишкин updated");
        session.saveOrUpdate(painting);

        transaction.commit();
        session.close();
        SESSION_FACTORY.close();
    }

    @Test
    public void testGet() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Painting painting = session.get(Painting.class, 6L);
        System.out.println(painting);
        painting.setAuthorName("Шишкин get");

        transaction.commit();
        session.close();
        SESSION_FACTORY.close();
    }

    @Test
    public void testLoad() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Painting painting = session.load(Painting.class, 6L);
        System.out.println(painting);
        painting.setAuthorName("Шишкин get");

        transaction.commit();
        session.close();
        SESSION_FACTORY.close();
    }

    @Test
    public void testDelete() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Painting painting = session.load(Painting.class, 6L);
        session.delete(painting);

        transaction.commit();
        session.close();
        SESSION_FACTORY.close();
    }

    @Test
    public void testRefresh() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Painting painting = session.load(Painting.class, 11L);
        System.out.println(painting);
        painting.setAuthorName("Шишкин Refresh");
        System.out.println(painting);

        session.refresh(painting);
        System.out.println(painting);

        transaction.commit();
        session.close();
        SESSION_FACTORY.close();
    }

    @Test
    public void testMerge() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Painting painting = session.load(Painting.class, 6L);
        System.out.println(painting);

        session.evict(painting);
        painting.setAuthorName("Шишкин merge");
        System.out.println(painting);

        Painting mergePainting = (Painting) session.merge(painting);
        session.refresh(painting);
        System.out.println(mergePainting);
        System.out.println(painting);

        transaction.commit();
        session.close();
        SESSION_FACTORY.close();
    }

}
