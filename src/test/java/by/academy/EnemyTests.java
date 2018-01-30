package by.academy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import javax.swing.text.html.parser.Entity;

/**
 * Created by user on 30.01.2018.
 */
public class EnemyTests {
    private static final SessionFactory SESSION_FACTORY = new Configuration().configure("hibernate_mysql.cfg.xml").buildSessionFactory();

    @Test
    public void tablePerClassHierarchy() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        ArmoredEnemy armoredEnemy = new ArmoredEnemy();
        armoredEnemy.setName("ArmoredEnemy");
        armoredEnemy.setArmorType("Leather");
        armoredEnemy.setArmorDurability("10");
        session.save(armoredEnemy);

        RangedEnemy rangedEnemy = new RangedEnemy();
        rangedEnemy.setName("RangedEnemy");
        rangedEnemy.setRangeOfFire("120");
        rangedEnemy.setWeaponType("Bow");
        session.save(rangedEnemy);

        InvisibleEnemy invisibleEnemy = new InvisibleEnemy();
        invisibleEnemy.setName("InvisibleEnemy");
        invisibleEnemy.setInvisibilityDuration("25");
        session.save(invisibleEnemy);


        transaction.commit();
        session.close();
        SESSION_FACTORY.close();
    }

    @Test
    public void testInheritance() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

//        ArmoredEnemy armoredEnemy = session.get(ArmoredEnemy.class, 1L);
//        System.out.println(armoredEnemy);

        session.createQuery("select m from Enemy m", Enemy.class)
                .list()
                .forEach(System.out::println);

        transaction.commit();
        session.close();
        SESSION_FACTORY.close();
    }
}
