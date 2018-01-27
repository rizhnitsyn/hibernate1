package by.academy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by user on 27.01.2018.
 */
public class InventoryTests {
    private static final SessionFactory SESSION_FACTORY = new Configuration().configure("hibernate_mysql.cfg.xml").buildSessionFactory();

    @Test
    public void inventorySaveTest() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Inventory inventory = new Inventory("Medical set");
        session.save(inventory);
        Items poison = new Items("Poison");
        Items drags = new Items("Drags");
        poison.setInventory(inventory);
        drags.setInventory(inventory);
        session.save(poison);
        session.save(drags);

        transaction.commit();
        session.close();
        SESSION_FACTORY.close();
    }

    @Test
    public void inventoryGetTest() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Inventory inventory = session.get(Inventory.class, 4L);
//
//        Items items = session.get(Items.class, 5L);

        transaction.commit();
        session.close();
        SESSION_FACTORY.close();
    }
}
