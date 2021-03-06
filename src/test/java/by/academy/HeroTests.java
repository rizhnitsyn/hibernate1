package by.academy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 25.01.2018.
 */
public class HeroTests {
    private static final SessionFactory SESSION_FACTORY = new Configuration().configure("hibernate_mysql.cfg.xml").buildSessionFactory();
    private static final SessionFactory SESSION_FACTORY_H2 = new Configuration().configure("hibernate_h2.cfg.xml").buildSessionFactory();

    @Test
    public void saveHeroTest() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        EquipmentSet firstEquipmentSet = new EquipmentSet("Sword", "Bow");
        EquipmentSet secondEquipmentSet = new EquipmentSet("Axe", "CrossBow");
        Inventory inventory = session.get(Inventory.class, 4L);
        Hero hero = new Hero("Mage2", Gender.MALE, firstEquipmentSet, secondEquipmentSet);
        hero.setInventory(inventory);
        session.save(hero);

        transaction.commit();
        session.close();
        SESSION_FACTORY.close();
    }

    @Test
    public void saveGetHeroTestH2() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

//        EquipmentSet firstEquipmentSet = new EquipmentSet("Sword", "Bow");
//        EquipmentSet secondEquipmentSet = new EquipmentSet("Axe", "CrossBow");
//        Inventory bag = new Inventory("Bag");
//        Items knife = new Items("knife");
//        Items paper = new Items("paper");
//        knife.setInventory(bag);
//        knife.setInventory(bag);
//        session.save(bag);
//        session.save(knife);
//        session.save(paper);
//        Hero hero = new Hero("Archer", Gender.MALE, firstEquipmentSet, secondEquipmentSet);
//        hero.setInventory(bag);
//        session.save(hero);

        Hero hero1 = session.get(Hero.class, 3L);

//        Hero hero2 = session.get(Hero.class, 1L);
//        Assert.assertEquals(hero.getName(), "Mage");

        transaction.commit();
        session.close();
        SESSION_FACTORY.close();
    }

    @Test
    public void genderTest() {
        EquipmentSet firstEquipmentSet = new EquipmentSet("Sword", "Bow");
        EquipmentSet secondEquipmentSet = new EquipmentSet("Axe", "CrossBow");
        Hero hero = new Hero("Mage", Gender.MALE, firstEquipmentSet, secondEquipmentSet);

        Assert.assertEquals(hero.isMan(), true);
        Assert.assertEquals(hero.isWoman(), false);
    }
}
